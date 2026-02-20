package Strategy.SimplePaymentSystem;

public class PaymentProcessor {

    public void processPayment(String paymentType, double amount) {

        if (paymentType.equals("credit")) {
            System.out.println("Processing credit card payment...");
            System.out.println("Charging $" + amount + " to credit card.");
        }
        else if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment...");
            System.out.println("Charging $" + amount + " via PayPal.");
        }
        else {
            throw new IllegalArgumentException("Unknown payment type");
        }

        System.out.println("Payment successful!\n");
    }
}