package ua.opnu.Task15;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас для знаходження найрідшого значення у мапі
 */
public class MapProcessor {
    
    /**
     * Знаходить значення, яке зустрічається найрідше у мапі
     * При однаковій частоті повертає найменше значення
     * 
     * @param map мапа для аналізу
     * @return найрідше значення
     */
    public static int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> frequency = new HashMap<>();
        
        // Підраховуємо частоту кожного значення
        for (Integer value : map.values()) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }
        
        int rarestValue = Integer.MAX_VALUE;
        int minFrequency = Integer.MAX_VALUE;
        
        // Знаходимо найрідше значення
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            
            // Якщо частота менша або частота однакова, але значення менше
            if (freq < minFrequency || (freq == minFrequency && value < rarestValue)) {
                minFrequency = freq;
                rarestValue = value;
            }
        }
        
        return rarestValue;
    }
}