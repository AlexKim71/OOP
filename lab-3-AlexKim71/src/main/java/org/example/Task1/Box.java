package org.example.Task1;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    // Приватні сеттери для валідації даних
    private void setLength(double length) {
        validateSide(length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide(height);
        this.height = height;
    }

    // Допоміжний метод для валідації
    private void validateSide(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Сторона коробки не може бути нулем або від'ємним числом.");
        }
    }

    // Публічні методи для розрахунків
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double getLateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    public double getVolume() {
        return length * width * height;
    }
}