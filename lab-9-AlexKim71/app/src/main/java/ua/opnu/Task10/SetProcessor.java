package ua.opnu.Task10;

import java.util.Iterator;
import java.util.Set;

/**
 * Клас для видалення рядків парної довжини з множини
 */
public class SetProcessor {
    
    /**
     * Видаляє з множини всі рядки парної довжини
     * 
     * @param set множина рядків для обробки
     */
    public static void removeEvenLength(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        
        // Використовуємо ітератор для безпечного видалення під час ітерації
        while (iterator.hasNext()) {
            String str = iterator.next();
            // Якщо довжина рядка парна - видаляємо
            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }
}