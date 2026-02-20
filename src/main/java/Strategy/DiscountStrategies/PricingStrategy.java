package Strategy.DiscountStrategies;

public interface PricingStrategy {
    double finalTotal(Cart cart);

    String name();
}