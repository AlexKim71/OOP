package ua.opnu.Task3;

/**
 * Клас для друку масивів різних типів
 */
public class Printer {
    
    /**
     * Узагальнений метод для друку елементів масиву
     */
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}