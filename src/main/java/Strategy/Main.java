package Strategy;

import Strategy.DiscountStrategies.*;
import Strategy.SimplePaymentSystem.BitcoinPaymentStrategy;
import Strategy.SimplePaymentSystem.CreditPaymentStrategy;
import Strategy.SimplePaymentSystem.PaymentProcessor;
import Strategy.SimplePaymentSystem.PaypalPaymentStrategy;

import java.util.List;

public class Main {
    static void main(String[] args) {
        executePaymentStrat();
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