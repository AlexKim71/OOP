package org.example.Task2;

public class Main {
    public static void main(String[] args) {
        // Створення товарів
        Item laptop = new Item(1, "Laptop", 1200.0);
        Item mouse = new Item(2, "Mouse", 25.0);
        Item keyboard = new Item(3, "Keyboard", 75.0);

        // Створення кошика та додавання товарів
        Cart myCart = new Cart();
        myCart.addItem(laptop);
        myCart.addItem(mouse);
        myCart.addItem(keyboard);

        // Видалення товару, щоб показати, що метод працює
        myCart.removeItem(mouse);

        // Створення замовлення
        Order myOrder = new Order(myCart, myCart.calculateTotalPrice());

        // Виведення результатів
        System.out.println("Товари в кошику:");
        for (Item item : myCart.getItems()) {
            System.out.println("- " + item.name() + ": $" + item.price());
        }

        System.out.println("-------------------------");
        System.out.println("Загальна вартість кошика: $" + myCart.calculateTotalPrice());
        System.out.println("Загальна вартість замовлення: $" + myOrder.orderTotal());
    }
}