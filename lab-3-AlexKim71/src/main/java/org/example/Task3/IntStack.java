package org.example.Task3;

import java.util.EmptyStackException;
import java.util.Arrays; // Додаємо імпорт

public class IntStack {

    private int[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public IntStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(int value) {
        ensureCapacity();
        this.elements[this.size] = value;
        this.size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = this.elements[this.size - 1];
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.elements[this.size - 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    private void ensureCapacity() {
        if (this.size == this.elements.length) {
            int newCapacity = this.elements.length * 2;
            this.elements = Arrays.copyOf(this.elements, newCapacity);
        }
    }
}