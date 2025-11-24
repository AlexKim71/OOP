package ua.opnu.Task12;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Клас для перевірки унікальності значень у мапі
 */
public class MapProcessor {
    
    /**
     * Перевіряє, чи всі значення у мапі є унікальними
     * 
     * @param map мапа для перевірки
     * @return true, якщо всі значення унікальні
     */
    public static boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        
        // Перевіряємо кожне значення
        for (String value : map.values()) {
            // Якщо значення вже існує - мапа не унікальна
            if (!values.add(value)) {
                return false;
            }
        }
        
        return true; // Всі значення унікальні
    }
}