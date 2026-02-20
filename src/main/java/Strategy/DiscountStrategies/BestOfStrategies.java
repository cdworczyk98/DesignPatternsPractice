package Strategy.DiscountStrategies;

import java.util.Comparator;
import java.util.List;

public class BestOfStrategies implements PricingStrategy {

    List<PricingStrategy> strategies;
    PricingStrategy lastWinner;

    public BestOfStrategies(List<PricingStrategy> strategies) {
        if(strategies.isEmpty()) throw new RuntimeException("You need to pass in at least one strategy.");
        this.strategies = strategies;
    }

    @Override
    public double finalTotal(Cart cart) {
        lastWinner = strategies.stream().min(Comparator.comparingDouble(e -> e.finalTotal(cart))).orElse(null);

        assert lastWinner != null;
        return lastWinner.finalTotal(cart);
    }

    @Override
    public String name() {
        if (lastWinner == null) {
            return "BestOf (not evaluated yet)";
        }
        return "Best of -> " + lastWinner.name();
    }
}
