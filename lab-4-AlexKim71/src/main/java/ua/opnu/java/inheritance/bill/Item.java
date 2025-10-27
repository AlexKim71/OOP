package ua.opnu.java.inheritance.bill;

public class Item {
    private String name;
    private double price;      // повна ціна
    private double discount;   // знижка для постійних клієнтів

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPriceWithDiscount(boolean regularCustomer) {
        if (regularCustomer) {
            return price - discount;
        }
        return price;
    }
}
