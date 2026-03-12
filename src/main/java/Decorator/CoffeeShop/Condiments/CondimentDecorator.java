package Decorator.CoffeeShop.Condiments;

import Decorator.CoffeeShop.Beverages.Beverage;
import lombok.Getter;

@Getter
public abstract class CondimentDecorator extends Beverage {

    private Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();

}
