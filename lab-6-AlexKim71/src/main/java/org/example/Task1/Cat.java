package org.example.Task1;

// Клас кішки
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Мяу!";
    }
}