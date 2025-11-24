package ua.opnu.Task16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас для підрахунку максимальної кількості входжень у списку
 */
public class ListProcessor {
    
    /**
     * Знаходить максимальну кількість входжень числа у списку
     * 
     * @param list список цілих чисел
     * @return максимальна кількість входжень
     */
    public static int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        
        Map<Integer, Integer> frequency = new HashMap<>();
        
        // Підраховуємо частоту кожного числа
        for (Integer num : list) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        int maxCount = 0;
        // Знаходимо максимальну частоту
        for (Integer count : frequency.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}