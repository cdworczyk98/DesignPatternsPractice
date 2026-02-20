package Strategy.DiscountStrategies;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PercentageOffStrategy implements PricingStrategy {
    private final double percent; // e.g. 10 = 10%

    public double finalTotal(Cart cart) {
        double sub = cart.subtotal();
        return sub * (1.0 - percent / 100.0);
    }

    public String name() {
        return percent + "% off";
    }
}