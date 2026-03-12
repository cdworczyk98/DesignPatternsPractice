import Decorator.Simple.Beverages.Beverage;
import Decorator.Simple.Beverages.DarkRoast;
import Decorator.Simple.Beverages.Espresso;
import Decorator.Simple.Beverages.HouseBlend;
import Decorator.Simple.CondimentCounter;
import Decorator.Simple.Condiments.Milk;
import Decorator.Simple.Condiments.Mocha;
import Decorator.Simple.Pointable;
import Decorator.Simple.SizeUpgrade.SmallSize;
import Observer.WeatheStation.Simple.PhoneDisplay;
import Observer.WeatheStation.Simple.StatisticsDisplay;
import Observer.WeatheStation.Simple.WeatherStation;
import Observer.WeatheStation.Simple.WebDashboard;
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
        Beverage b2 = new Milk(new SmallSize(new DarkRoast()));
        Beverage b3 = new Pointable(new Mocha(new Mocha(new Milk(new SmallSize(new DarkRoast())))));
        Beverage b4 = new SmallSize(new Milk(new DarkRoast()));

        Beverage b5 = new HouseBlend();
        b3 = new Mocha(b3);
        b3 = new Milk(b3);

        System.out.println(CondimentCounter.countCondiment(b2, Milk.class));

        printBev(b1);
        printBev(b2);
        printBev(b3);
        printBev(b4);
        printBev(b5);
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