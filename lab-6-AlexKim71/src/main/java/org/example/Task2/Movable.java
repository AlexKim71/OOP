package org.example.Task2;

// Інтерфейс для об'єктів що можуть переміщуватися
public interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    void moveTo(double x, double y);
}