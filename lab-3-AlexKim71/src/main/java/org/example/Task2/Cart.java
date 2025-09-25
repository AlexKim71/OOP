package org.example.Task2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Item item : this.items) {
            total += item.price();
        }
        return total;
    }

    public List<Item> getItems() {
        return new ArrayList<>(this.items);
    }
}