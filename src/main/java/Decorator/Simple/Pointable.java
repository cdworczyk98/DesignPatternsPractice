package Decorator.Simple;

import Decorator.Simple.Beverages.Beverage;
import Decorator.Simple.Condiments.CondimentDecorator;

public class Pointable extends CondimentDecorator {

    private int points;

    public Pointable(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        points = (int) (getBeverage().cost() / 0.50);
        System.out.println("Points earned = " + points);
        return getBeverage().cost();
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription();
    }
}
