package org.example.Task1;

// Клас собаки
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Гав!";
    }
}