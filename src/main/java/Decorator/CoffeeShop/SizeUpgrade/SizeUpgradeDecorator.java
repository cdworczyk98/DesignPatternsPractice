package Decorator.CoffeeShop.SizeUpgrade;

import Decorator.CoffeeShop.Beverages.Beverage;

public abstract class SizeUpgradeDecorator extends Beverage {

    Beverage beverage;

    public SizeUpgradeDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
}
