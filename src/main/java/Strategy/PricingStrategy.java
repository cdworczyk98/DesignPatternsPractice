package Strategy;

interface PricingStrategy {
    double finalTotal(Cart cart);
    String name();
}