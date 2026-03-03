package Decorator.CoffeeShop.Beverages;

import Decorator.CoffeeShop.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}