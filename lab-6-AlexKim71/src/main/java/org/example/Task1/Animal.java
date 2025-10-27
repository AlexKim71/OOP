package org.example.Task1;

// Абстрактний клас тварини
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактний метод для звуку тварини
    public abstract String makeSound();
}