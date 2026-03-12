package Decorator.CoffeeShop.Condiments;

import Decorator.CoffeeShop.Beverages.Beverage;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Milk";
    }


    @Override
    public double cost() {
        return getBeverage().cost() + 0.5;
    }
}
