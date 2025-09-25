package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;    // Оголошено як final
    private final int year;       // Оголошено як final
    private final List<String> courses; // Оголошено як final

    public Student(String name, int year) {
        this.name = name;
        this.year = (year >= 1 && year <= 4) ? year : 0;
        this.courses = new ArrayList<>(); // Ініціалізація final-поля
    }

    public void addCourse(String courseName) {
        courses.add(courseName);
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return 20000 * year;
    }

    public int getYear() {
        return year;
    }

    public static void main(String[] args) {
        Student student = new Student("John", 3);
        student.addCourse("Math");
        student.addCourse("Physics");
        student.addCourse("Chemistry");
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());

        // Демонстрація використання dropAll()
        student.dropAll();
        System.out.println("Після dropAll(): " + student.getCourseCount()); // Виведе 0
    }
}