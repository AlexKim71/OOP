package ua.opnu.Task4;

import java.util.List;

/**
 * Клас для видалення дублікатів з відсортованого списку
 */
public class ListProcessor {
    
    /**
     * Видаляє дублікати з відсортованого списку
     * 
     * @param list відсортований список рядків
     */
    public static void removeDuplicates(List<String> list) {
        int i = 0;
        // Проходимо по списку та порівнюємо сусідні елементи
        while (i < list.size() - 1) {
            // Якщо поточний елемент дорівнює наступному - видаляємо наступний
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++; // Переходимо до наступного елемента тільки якщо не було видалення
            }
        }
    }
}