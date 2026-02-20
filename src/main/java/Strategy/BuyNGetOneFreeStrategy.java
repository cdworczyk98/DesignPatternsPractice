package Strategy;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class BuyNGetOneFreeStrategy implements PricingStrategy {
    private final int n; // buy N, get 1 free (cheapest item free is a later upgrade)

    public double finalTotal(Cart cart) {
        // naive: “one free item” valued as average item price
        double sub = cart.subtotal();
        Item cheapestItem = getCheapestItem(cart.getItems());
        if (cart.getItemCount() == 0) return 0.0;
        return sub - cheapestItem.getPrice();
    }

    public Item getCheapestItem(List<Item> items) {
        return items.stream().min(Comparator.comparingDouble(Item::getPrice)).orElse(null);
    }

    public String name() {
        return "Buy " + n + " get cheapest item for free";
    }
}