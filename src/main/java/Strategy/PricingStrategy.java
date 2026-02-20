package Strategy;

public interface PricingStrategy {
    double finalTotal(Cart cart);

    String name();
}