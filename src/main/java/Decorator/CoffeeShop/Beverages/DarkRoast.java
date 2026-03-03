package Decorator.CoffeeShop.Beverages;

import Decorator.CoffeeShop.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 1.49;
    }
}
