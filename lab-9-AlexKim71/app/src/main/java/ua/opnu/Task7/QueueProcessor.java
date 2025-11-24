package ua.opnu.Task7;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Клас для перевпорядкування черги за знаком чисел
 */
public class QueueProcessor {
    
    /**
     * Перевпорядковує чергу: спочатку від'ємні числа, потім додатні
     * Вхідна черга відсортована за абсолютним значенням
     * 
     * @param queue черга цілих чисел
     */
    public static void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> negatives = new ArrayDeque<>();
        ArrayDeque<Integer> positives = new ArrayDeque<>();
        
        // Розділяємо числа на від'ємні та додатні
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num < 0) {
                negatives.push(num); // Використовуємо як стек для реверсу
            } else {
                positives.offer(num); // Використовуємо як чергу
            }
        }
        
        // Спочатку додаємо від'ємні числа (у зворотному порядку)
        while (!negatives.isEmpty()) {
            queue.offer(negatives.pop());
        }
        
        // Потім додаємо додатні числа
        while (!positives.isEmpty()) {
            queue.offer(positives.poll());
        }
    }
}