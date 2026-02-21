package Strategy.SimplePaymentSystem;

public class CreditPaymentStrategy implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Charging $" + amount + " to credit card.");
    }

    @Override
    public String getPaymentName() {
        return getClass().getSimpleName();
    }
}
