package org.example.Task3;

public class Main {
    public static void main(String[] args) {
        IntStack stack = new IntStack();

        // Додаємо елементи
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        // Подивитися верхній елемент
        System.out.println("Peek: " + stack.peek());

        // Витягнути елемент
        System.out.println("Pop: " + stack.pop());
        System.out.println(stack);

        // Перевірка розміру
        System.out.println("Size: " + stack.size());

        // Очистка
        stack.clear();
        System.out.println("Is empty: " + stack.isEmpty());
    }
}