package ua.opnu.Task2;

import java.util.List;

/**
 * Клас для дублювання елементів у списку
 */
public class ListProcessor {
    
    /**
     * Дублює кожен рядок у списку
     * 
     * @param list список рядків для обробки
     */
    public static void stutter(List<String> list) {
        // Проходимо по списку з кроком 2, щоб врахувати додавання елементів
        for (int i = 0; i < list.size(); i += 2) {
            String element = list.get(i);
            // Додаємо копію елемента після оригіналу
            list.add(i + 1, element);
        }
    }
}