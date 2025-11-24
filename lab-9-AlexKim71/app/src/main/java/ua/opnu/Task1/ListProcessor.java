package ua.opnu.Task1;

import java.util.List;

/**
 * Клас для обробки списків рядків
 */
public class ListProcessor {
    
    /**
     * Видаляє коротші рядки з кожної пари елементів у списку
     * При однаковій довжині видаляє перший елемент пари
     * 
     * @param list список рядків для обробки
     */
    public static void removeShorterStrings(List<String> list) {
        // Проходимо по парах елементів (0-1, 2-3, 4-5, ...)
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);
            
            // Якщо перший рядок коротший або рівний за довжиною - видаляємо його
            if (first.length() <= second.length()) {
                list.remove(i);
                i--; // Зменшуємо індекс, оскільки список зменшився
            } else {
                // Інакше видаляємо другий рядок
                list.remove(i + 1);
                i--; // Зменшуємо індекс, оскільки список зменшився
            }
        }
    }
}