package org.example.Task1;

public class Main {
    public static void main(String[] args) {
        try {
            Box box = new Box(10.0, 5.0, 2.5);

            System.out.println("Площа поверхні: " + box.getSurfaceArea());
            System.out.println("Площа бічної поверхні: " + box.getLateralSurfaceArea());
            System.out.println("Об'єм: " + box.getVolume());

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}