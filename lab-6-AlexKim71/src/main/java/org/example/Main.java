package org.example;
// Импорт необходимых классов из других пакетов
import org.example.Task1.Dog;
import org.example.Task1.Cat;
import org.example.Task2.Point;
import org.example.Task3.Smartphone;
import org.example.Task4.Car;
import org.example.Task5.DrawApp; // <-- Новый импорт
import org.example.Task6.SortingListDemo;

import java.util.Arrays;
import javax.swing.SwingUtilities; // <-- Новый импорт для GUI

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота 6: Абстрактні класи та інтерфейси ===");

        // Завдання 1: Тестування Animal, Dog, Cat
        System.out.println("\n--- Завдання 1: Animal ---");
        Dog dog = new Dog("Рекс");
        Cat cat = new Cat("Мурка");

        System.out.println(dog.getName() + " каже: " + dog.makeSound());
        System.out.println(cat.getName() + " каже: " + cat.makeSound());

        // Завдання 2: Тестування Point з Movable
        System.out.println("\n--- Завдання 2: Point (Movable) ---");
        Point point = new Point(1.5, 2.5);
        System.out.println("Початкові координати: (" + point.getX() + ", " + point.getY() + ")");

        point.moveTo(5.0, 7.0);
        System.out.println("Після moveTo(5.0, 7.0): (" + point.getX() + ", " + point.getY() + ")");

        point.setX(10.0);
        point.setY(15.0);
        System.out.println("Після setX(10.0), setY(15.0): (" + point.getX() + ", " + point.getY() + ")");

        // Завдання 3: Тестування Smartphone
        System.out.println("\n--- Завдання 3: Smartphone ---");
        Smartphone phone = new Smartphone(50.4501, 30.5234);

        double[] coords = phone.getCoordinates();
        System.out.println("GPS координати: " + Arrays.toString(coords));

        phone.makeCall();
        phone.receiveCall();

        // Завдання 4: Тестування Car з Comparable
        System.out.println("\n--- Завдання 4: Car (Comparable) ---");
        Car car1 = new Car(25000, 2020, 150);
        Car car2 = new Car(30000, 2019, 180);
        Car car3 = new Car(25000, 2021, 150);

        System.out.println("Порівняння car1 (25000, 2020, 150) з car2 (30000, 2019, 180): " + car1.compareTo(car2));
        System.out.println("Порівняння car1 (25000, 2020, 150) з car3 (25000, 2021, 150): " + car1.compareTo(car3));
        System.out.println("Порівняння car2 (30000, 2019, 180) з car1 (25000, 2020, 150): " + car2.compareTo(car1));

        // Завдання 5: Draw додаток (розкоментуйте для запуску GUI)
        System.out.println("\n--- Завдання 5: Draw додаток ---");
        System.out.println("Для запуску GUI розкоментуйте:");
        System.out.println("// SwingUtilities.invokeLater(() -> new DrawApp());");
        // SwingUtilities.invokeLater(() -> new DrawApp());

        // Завдання 6: Демонстрація сортування студентів
        SortingListDemo.demonstrateSorting();
    }
}