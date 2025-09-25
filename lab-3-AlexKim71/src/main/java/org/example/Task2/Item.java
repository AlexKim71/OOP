package org.example.Task2;

public record Item(long id, String name, double price) {
    // Всі поля final, конструктор та гетери генеруються автоматично
    // toString(), equals() та hashCode() також генеруються.
    // Тут не потрібно писати нічого, якщо не треба додавати власну логіку.
}