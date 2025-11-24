package ua.opnu.Task13;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас для знаходження перетину мап
 */
public class MapProcessor {
    
    /**
     * Знаходить перетин двох мап (пари ключ-значення, що присутні в обох)
     * 
     * @param map1 перша мапа
     * @param map2 друга мапа
     * @return нова мапа з перетином
     */
    public static Map<String, String> intersect(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> result = new HashMap<>();
        
        // Перевіряємо кожну пару з першої мапи
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            // Якщо друга мапа містить той же ключ з тим же значенням
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }
        
        return result;
    }
}