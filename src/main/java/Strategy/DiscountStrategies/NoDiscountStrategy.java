package Strategy.DiscountStrategies;

public class NoDiscountStrategy implements PricingStrategy {
    public double finalTotal(Cart cart) {
        return cart.subtotal();
    }

    public String name() {
        return "No discount";
    }
}