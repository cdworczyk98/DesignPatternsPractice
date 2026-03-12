package Decorator.Simple.SizeUpgrade;

import Decorator.Simple.Beverages.Beverage;

public class SmallSize extends SizeUpgradeDecorator{

    public SmallSize(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return "(SMALL) " + beverage.getDescription();
    }

    @Override
    public double cost() {
        return 0.8 * beverage.cost();
    }
}
