package Strategy.DiscountStrategies;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Checkout {
    private PricingStrategy pricingStrategy;

    public double total(Cart cart) {
        return pricingStrategy.finalTotal(cart);
    }

    public String strategyName() {
        return pricingStrategy.name();
    }
}