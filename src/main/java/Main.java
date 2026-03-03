import Decorator.CoffeeShop.Beverages.Beverage;
import Decorator.CoffeeShop.Beverages.DarkRoast;
import Decorator.CoffeeShop.Beverages.Espresso;
import Decorator.CoffeeShop.Beverages.HouseBlend;
import Decorator.CoffeeShop.Condiments.Milk;
import Decorator.CoffeeShop.Condiments.Mocha;
import Decorator.CoffeeShop.SizeUpgrade.SmallSize;
import Observer.WeatheStation.PhoneDisplay;
import Observer.WeatheStation.StatisticsDisplay;
import Observer.WeatheStation.WeatherStation;
import Observer.WeatheStation.WebDashboard;
import Strategy.DiscountStrategies.*;
import Strategy.SimplePaymentSystem.BitcoinPaymentStrategy;
import Strategy.SimplePaymentSystem.CreditPaymentStrategy;
import Strategy.SimplePaymentSystem.PaymentProcessor;
import Strategy.SimplePaymentSystem.PaypalPaymentStrategy;

import java.util.List;

public class Main {
    static void main(String[] args) {
        executeCoffeeShop();
    }

    public static void executeCoffeeShop() {

        Beverage b1 = new Espresso();

        Beverage b2 = new SmallSize(new Milk(new DarkRoast()));
        Beverage b21 = new Milk(new SmallSize(new DarkRoast()));
        Beverage b22 = new SmallSize(new Milk(new DarkRoast()));

        Beverage b3 = new HouseBlend();
        b3 = new Mocha(b3);
        b3 = new Milk(b3);

        printBev(b1);
        printBev(b2);
        printBev(b21);
        printBev(b3);
    }

    private static void printBev(Beverage b) {
        System.out.printf("%-40s £%.2f%n",  b.getDescription(), b.cost());
    }

    public static void executeObserver() {
        PhoneDisplay phone = new PhoneDisplay();
        WebDashboard web = new WebDashboard();
        StatisticsDisplay statistics = new StatisticsDisplay();
        WeatherStation station = new WeatherStation();

        station.registerObserver(phone);
        station.registerObserver(web);
        station.registerObserver(statistics);

        station.setMeasurements(21.5f, 45.0f);
        station.setMeasurements(19.0f, 60.0f);
        station.setMeasurements(22.0f, 65.0f);
        station.setMeasurements(10.0f, 30.0f);
        station.setMeasurements(40.0f, 75.0f);
    }

    public static void executePaymentStrat() {
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(new CreditPaymentStrategy(), 100);
        processor.processPayment(new PaypalPaymentStrategy(), 250);
        processor.processPayment(new BitcoinPaymentStrategy(), 500);
    }

    public static void executeDiscountStrat() {
        Cart cart = new Cart();
        cart.add(new Item("Coffee", 3.50));
        cart.add(new Item("Sandwich", 6.00));
        cart.add(new Item("Cookie", 2.25));

        List<PricingStrategy> pricingStrategyList = List.of(new NoDiscountStrategy(), new PercentageOffStrategy(10), new BuyNGetOneFreeStrategy(2));

        Checkout checkout = new Checkout(new NoDiscountStrategy());

        System.out.println("\nSubtotal: " + cart.subtotal());

        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));

        // Swap strategy at runtime:
        checkout.setPricingStrategy(new PercentageOffStrategy(10));
        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));

        checkout.setPricingStrategy(new BuyNGetOneFreeStrategy(2));
        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));

        checkout.setPricingStrategy(new BestOfStrategies(pricingStrategyList));
        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));
    }

}