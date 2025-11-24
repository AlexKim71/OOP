package ua.opnu.Task6;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Клас для перевірки паліндромів у черзі
 */
public class QueueProcessor {
    
    /**
     * Перевіряє, чи є послідовність чисел у черзі паліндромом
     * Зберігає оригінальний стан черги
     * 
     * @param queue черга цілих чисел
     * @return true, якщо послідовність є паліндромом
     */
    public static boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true; // Пуста черга вважається паліндромом
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        
        // Переносимо елементи з черги в стек та повертаємо назад у чергу
        for (int i = 0; i < size; i++) {
            Integer element = queue.poll();
            stack.push(element);
            queue.offer(element);
        }
        
        // Порівнюємо елементи черги з елементами стеку
        for (int i = 0; i < size; i++) {
            Integer fromQueue = queue.poll();
            Integer fromStack = stack.pop();
            queue.offer(fromQueue); // Повертаємо елемент назад у чергу
            
            if (!fromQueue.equals(fromStack)) {
                return false;
            }
        }
        
        return true;
    }
}