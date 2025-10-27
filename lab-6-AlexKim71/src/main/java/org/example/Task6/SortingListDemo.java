package org.example.Task6;

import java.util.ArrayList;
import java.util.List;

public class SortingListDemo {
    private List<Student> students;
    private boolean nameAscending = true;
    private boolean lastNameAscending = true;
    private boolean markAscending = true;

    public SortingListDemo() {
        students = new ArrayList<>();
        populateList();
    }

    private void populateList() {
        students.add(new Student("Борис", "Іванов", 75));
        students.add(new Student("Петро", "Петренко", 92));
        students.add(new Student("Сергій", "Сергієнко", 61));
        students.add(new Student("Григорій", "Сковорода", 88));
    }

    public void printStudents() {
        System.out.println("Список студентів:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public void sortByName() {
        students.sort(new NameSorter(nameAscending));
        System.out.println("Сортування за ім'ям (" + (nameAscending ? "за зростанням" : "за спаданням") + "):");
        nameAscending = !nameAscending;
        printStudents();
    }

    public void sortByLastName() {
        students.sort(new LastNameSorter(lastNameAscending));
        System.out.println("Сортування за прізвищем (" + (lastNameAscending ? "за зростанням" : "за спаданням") + "):");
        lastNameAscending = !lastNameAscending;
        printStudents();
    }

    public void sortByMark() {
        students.sort(new MarkSorter(markAscending));
        System.out.println("Сортування за середнім балом (" + (markAscending ? "за зростанням" : "за спаданням") + "):");
        markAscending = !markAscending;
        printStudents();
    }

    public static void demonstrateSorting() {
        System.out.println("\n=== Завдання 6: Додаток SortingList ===");
        SortingListDemo demo = new SortingListDemo();
        
        System.out.println("Початковий список:");
        demo.printStudents();
        
        System.out.println("\n1. Перше сортування за ім'ям:");
        demo.sortByName();
        
        System.out.println("\n2. Друге сортування за ім'ям (зворотне):");
        demo.sortByName();
        
        System.out.println("\n3. Перше сортування за прізвищем:");
        demo.sortByLastName();
        
        System.out.println("\n4. Перше сортування за середнім балом:");
        demo.sortByMark();
    }
}