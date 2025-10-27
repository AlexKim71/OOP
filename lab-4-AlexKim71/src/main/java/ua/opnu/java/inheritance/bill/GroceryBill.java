package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> items;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }

    public Employee getClerk() {
        return clerk;
    }

    public void add(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0.0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public List<Item> getItems() {
        return items;
    }
}