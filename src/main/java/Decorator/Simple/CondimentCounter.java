package Decorator.Simple;

import Decorator.Simple.Beverages.Beverage;
import Decorator.Simple.Condiments.CondimentDecorator;

public class CondimentCounter {

    public static int countCondiment(Beverage beverage, Class<?> type) {

        int count = 0;
        Beverage current = beverage;

        while (current instanceof CondimentDecorator) {
            if(type.isInstance(beverage)) {
                count++;
            }

            current = ((CondimentDecorator) current).getBeverage();
        }

        return count;
    }

}
