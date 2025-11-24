package ua.opnu.Task5;

/**
 * Клас з узагальненим методом для перевірки входження елемента в масив
 */
public class GenericContains {
    
    /**
     * Узагальнений метод для перевірки наявності елемента в масиві
     */
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item != null && item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}