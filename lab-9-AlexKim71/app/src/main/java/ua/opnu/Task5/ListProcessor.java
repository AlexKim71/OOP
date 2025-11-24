package ua.opnu.Task5;

import java.util.List;

/**
 * Клас для позначення рядків довжиною 4 символи
 */
public class ListProcessor {
    
    /**
     * Додає маркер "****" перед кожним рядком довжиною 4 символи
     * 
     * @param list список рядків для обробки
     */
    public static void markLength4(List<String> list) {
        int i = 0;
        // Проходимо по списку
        while (i < list.size()) {
            // Якщо рядок має довжину 4 символи
            if (list.get(i).length() == 4) {
                // Додаємо маркер перед ним
                list.add(i, "****");
                i += 2; // Пропускаємо маркер та сам рядок
            } else {
                i++; // Переходимо до наступного елемента
            }
        }
    }
}