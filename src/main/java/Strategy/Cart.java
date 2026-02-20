package Strategy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public double subtotal() {
        double sum = 0.0;
        for (Item i : items) sum += i.getPrice();
        return sum;
    }

    public int getItemCount() {
        return items.size();
    }

}
