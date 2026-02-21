package Strategy.SimplePaymentSystem;

public interface PaymentStrategy {

    void processPayment(double amount);

    String getPaymentName();

}
