package Strategy;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new Item("Coffee", 3.50));
        cart.add(new Item("Sandwich", 6.00));
        cart.add(new Item("Cookie", 2.25));

        Checkout checkout = new Checkout(new NoDiscountStrategy());

        System.out.println("Subtotal: " + cart.subtotal());
        System.out.println("Strategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));

        // Swap strategy at runtime:
        checkout.setPricingStrategy(new PercentageOffStrategy(10));
        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));

        checkout.setPricingStrategy(new BuyNGetOneFreeStrategy(2));
        System.out.println("\nStrategy: " + checkout.strategyName());
        System.out.println("Total:    " + checkout.total(cart));
    }
}