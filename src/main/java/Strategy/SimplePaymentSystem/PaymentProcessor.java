package Strategy.SimplePaymentSystem;

public class PaymentProcessor {

    public void processPayment(PaymentStrategy paymentType, double amount) {

        System.out.printf("Processing %s payment...%n", paymentType.getPaymentName());
        paymentType.processPayment(amount);

        System.out.println("Payment successful!\n");
    }
}