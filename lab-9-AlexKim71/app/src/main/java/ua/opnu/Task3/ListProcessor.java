package ua.opnu.Task3;

import java.util.List;

/**
 * Клас для зміни місцями пар елементів у списку
 */
public class ListProcessor {
    
    /**
     * Змінює місцями елементи в кожній парі
     * 
     * @param list список рядків для обробки
     */
    public static void switchPairs(List<String> list) {
        // Проходимо по парах елементів
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);
            
            // Міняємо місцями
            list.set(i, second);
            list.set(i + 1, first);
        }
    }
}