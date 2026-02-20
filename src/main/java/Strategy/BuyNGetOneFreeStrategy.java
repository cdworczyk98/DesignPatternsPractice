package Strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BuyNGetOneFreeStrategy implements PricingStrategy {
    private final int n; // buy N, get 1 free (cheapest item free is a later upgrade)

    public double finalTotal(Cart cart) {
        // naive: “one free item” valued as average item price
        double sub = cart.subtotal();
        int freeItems = cart.getItemCount() / (n + 1);
        if (cart.getItemCount() == 0) return 0.0;
        double avg = sub / cart.getItemCount();
        return sub - freeItems * avg;
    }

    public String name() {
        return "Buy " + n + " get 1 free (naive)";
    }
}