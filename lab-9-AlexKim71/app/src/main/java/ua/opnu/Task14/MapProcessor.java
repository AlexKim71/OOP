package ua.opnu.Task14;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас для реверсу ключів та значень у мапі
 */
public class MapProcessor {
    
    /**
     * Створює нову мапу з поміняними місцями ключами та значеннями
     * При дублікатах значень зберігає останню пару
     * 
     * @param map оригінальна мапа
     * @return нова мапа з реверсованими ключами та значеннями
     */
    public static Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        
        // Міняємо місцями ключі та значення
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            
            // Значення стає ключем, ключ стає значенням
            result.put(value, key);
        }
        
        return result;
    }
}