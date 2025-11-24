package ua.opnu.Task4;

/**
 * Узагальнений інтерфейс для перевірки умови
 */
public interface Predicate<T> {
    boolean test(T t);
}