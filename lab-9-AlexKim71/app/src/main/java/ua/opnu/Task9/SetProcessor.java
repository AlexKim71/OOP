package ua.opnu.Task9;

import java.util.Set;

/**
 * Клас для роботи з множинами рядків
 */
public class SetProcessor {
    
    /**
     * Знаходить довжину найдовшого рядка у множині
     * 
     * @param set множина рядків
     * @return довжина найдовшого рядка або 0 для пустої множини
     */
    public static int maxLength(Set<String> set) {
        if (set.isEmpty()) {
            return 0;
        }
        
        int maxLen = 0;
        // Проходимо по всіх рядках у множині
        for (String str : set) {
            if (str.length() > maxLen) {
                maxLen = str.length();
            }
        }
        
        return maxLen;
    }
}