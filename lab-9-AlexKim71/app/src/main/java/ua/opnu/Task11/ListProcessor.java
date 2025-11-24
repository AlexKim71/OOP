package ua.opnu.Task11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Клас для знаходження спільних елементів у списках
 */
public class ListProcessor {
    
    /**
     * Підраховує кількість унікальних чисел, що зустрічаються в обох списках
     * 
     * @param list1 перший список цілих чисел
     * @param list2 другий список цілих чисел
     * @return кількість спільних унікальних елементів
     */
    public static int numInCommon(List<Integer> list1, List<Integer> list2) {
        // Створюємо множину з елементів першого списку
        Set<Integer> set1 = new HashSet<>(list1);
        
        // Створюємо множину для спільних елементів
        Set<Integer> common = new HashSet<>();
        
        // Перевіряємо кожен елемент другого списку
        for (Integer num : list2) {
            if (set1.contains(num)) {
                common.add(num); // Додаємо тільки унікальні спільні елементи
            }
        }
        
        return common.size();
    }
}