package ua.opnu.Task8;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Клас для перегрупування черги за парністю чисел
 */
public class QueueProcessor {
    
    /**
     * Перегруповує чергу: спочатку парні числа, потім непарні
     * Зберігає порядок елементів у кожній групі
     * 
     * @param queue черга цілих чисел
     */
    public static void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> evens = new ArrayDeque<>();
        ArrayDeque<Integer> odds = new ArrayDeque<>();
        
        // Розділяємо числа на парні та непарні
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num % 2 == 0) {
                evens.offer(num); // Парні числа
            } else {
                odds.offer(num); // Непарні числа
            }
        }
        
        // Спочатку додаємо парні числа
        while (!evens.isEmpty()) {
            queue.offer(evens.poll());
        }
        
        // Потім додаємо непарні числа
        while (!odds.isEmpty()) {
            queue.offer(odds.poll());
        }
    }
}