package ua.opnu;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Головний клас для демонстрації всіх завдань лабораторної роботи 9
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНА РОБОТА 9: КОЛЕКЦІЇ В JAVA ===\n");
        
        demonstrateTask1();
        demonstrateTask2();
        demonstrateTask3();
        demonstrateTask4();
        demonstrateTask5();
        demonstrateTask6();
        demonstrateTask7();
        demonstrateTask8();
        demonstrateTask9();
        demonstrateTask10();
        demonstrateTask11();
        demonstrateTask12();
        demonstrateTask13();
        demonstrateTask14();
        demonstrateTask15();
        demonstrateTask16();
    }

    /**
     * Демонстрація removeShorterStrings (Завдання 1)
     */
    private static void demonstrateTask1() {
        System.out.println("=== ЗАВДАННЯ 1: removeShorterStrings ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("four", "score", "and", "seven", "years", "ago"));
        System.out.println("До обробки: " + list);
        
        ua.opnu.Task1.ListProcessor.removeShorterStrings(list);
        System.out.println("Після обробки: " + list);
        
        System.out.println();
    }

    /**
     * Демонстрація stutter (Завдання 2)
     */
    private static void demonstrateTask2() {
        System.out.println("=== ЗАВДАННЯ 2: stutter ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("how", "are", "you?"));
        System.out.println("До обробки: " + list);
        
        ua.opnu.Task2.ListProcessor.stutter(list);
        System.out.println("Після обробки: " + list);
        
        System.out.println();
    }

    /**
     * Демонстрація switchPairs (Завдання 3)
     */
    private static void demonstrateTask3() {
        System.out.println("=== ЗАВДАННЯ 3: switchPairs ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("four", "score", "and", "seven", "years", "ago"));
        System.out.println("До обробки: " + list);
        
        ua.opnu.Task3.ListProcessor.switchPairs(list);
        System.out.println("Після обробки: " + list);
        
        System.out.println();
    }

    /**
     * Демонстрація removeDuplicates (Завдання 4)
     */
    private static void demonstrateTask4() {
        System.out.println("=== ЗАВДАННЯ 4: removeDuplicates ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("be", "be", "is", "not", "or", "question", "that", "the", "to", "to"));
        System.out.println("До обробки: " + list);
        
        ua.opnu.Task4.ListProcessor.removeDuplicates(list);
        System.out.println("Після обробки: " + list);
        
        System.out.println();
    }

    /**
     * Демонстрація markLength4 (Завдання 5)
     */
    private static void demonstrateTask5() {
        System.out.println("=== ЗАВДАННЯ 5: markLength4 ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        System.out.println("До обробки: " + list);
        
        ua.opnu.Task5.ListProcessor.markLength4(list);
        System.out.println("Після обробки: " + list);
        
        System.out.println();
    }

    /**
     * Демонстрація isPalindrome (Завдання 6)
     */
    private static void demonstrateTask6() {
        System.out.println("=== ЗАВДАННЯ 6: isPalindrome ===");
        
        Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(3, 8, 17, 9, 17, 8, 3));
        System.out.println("Черга 1: " + queue1);
        System.out.println("Є паліндромом: " + ua.opnu.Task6.QueueProcessor.isPalindrome(queue1));
        System.out.println("Черга після перевірки: " + queue1);
        
        Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(3, 8, 17, 9, 4, 17, 8, 3));
        System.out.println("\nЧерга 2: " + queue2);
        System.out.println("Є паліндромом: " + ua.opnu.Task6.QueueProcessor.isPalindrome(queue2));
        System.out.println("Черга після перевірки: " + queue2);
        
        System.out.println();
    }

    /**
     * Демонстрація reorder (Завдання 7)
     */
    private static void demonstrateTask7() {
        System.out.println("=== ЗАВДАННЯ 7: reorder ===");
        
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, -2, 4, -5, 8, -8, 12, -15, 23));
        System.out.println("До обробки: " + queue);
        
        ua.opnu.Task7.QueueProcessor.reorder(queue);
        System.out.println("Після обробки: " + queue);
        
        System.out.println();
    }

    /**
     * Демонстрація rearrange (Завдання 8)
     */
    private static void demonstrateTask8() {
        System.out.println("=== ЗАВДАННЯ 8: rearrange ===");
        
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(3, 5, 4, 17, 6, 83, 1, 84, 16, 37));
        System.out.println("До обробки: " + queue);
        
        ua.opnu.Task8.QueueProcessor.rearrange(queue);
        System.out.println("Після обробки: " + queue);
        
        System.out.println();
    }

    /**
     * Демонстрація maxLength (Завдання 9)
     */
    private static void demonstrateTask9() {
        System.out.println("=== ЗАВДАННЯ 9: maxLength ===");
        
        Set<String> set = new HashSet<>(Arrays.asList("one", "two", "three"));
        System.out.println("Множина: " + set);
        System.out.println("Максимальна довжина: " + ua.opnu.Task9.SetProcessor.maxLength(set));
        
        System.out.println();
    }

    /**
     * Демонстрація removeEvenLength (Завдання 10)
     */
    private static void demonstrateTask10() {
        System.out.println("=== ЗАВДАННЯ 10: removeEvenLength ===");
        
        Set<String> set = new HashSet<>(Arrays.asList("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));
        System.out.println("До обробки: " + set);
        
        ua.opnu.Task10.SetProcessor.removeEvenLength(set);
        System.out.println("Після обробки: " + set);
        
        System.out.println();
    }

    /**
     * Демонстрація numInCommon (Завдання 11)
     */
    private static void demonstrateTask11() {
        System.out.println("=== ЗАВДАННЯ 11: numInCommon ===");
        
        List<Integer> list1 = Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
        List<Integer> list2 = Arrays.asList(-5, 15, 2, -1, 7, 15, 36);
        
        System.out.println("Список 1: " + list1);
        System.out.println("Список 2: " + list2);
        System.out.println("Спільних елементів: " + ua.opnu.Task11.ListProcessor.numInCommon(list1, list2));
        
        System.out.println();
    }

    /**
     * Демонстрація isUnique (Завдання 12)
     */
    private static void demonstrateTask12() {
        System.out.println("=== ЗАВДАННЯ 12: isUnique ===");
        
        Map<String, String> map1 = new HashMap<>();
        map1.put("Marty", "Stepp");
        map1.put("Stuart", "Reges");
        map1.put("Jessica", "Miller");
        map1.put("Amanda", "Camp");
        map1.put("Hal", "Perkins");
        
        System.out.println("Мапа 1: " + map1);
        System.out.println("Унікальна: " + ua.opnu.Task12.MapProcessor.isUnique(map1));
        
        Map<String, String> map2 = new HashMap<>();
        map2.put("Kendrick", "Perkins");
        map2.put("Stuart", "Reges");
        map2.put("Jessica", "Miller");
        map2.put("Bruce", "Reges");
        map2.put("Hal", "Perkins");
        
        System.out.println("\nМапа 2: " + map2);
        System.out.println("Унікальна: " + ua.opnu.Task12.MapProcessor.isUnique(map2));
        
        System.out.println();
    }

    /**
     * Демонстрація intersect (Завдання 13)
     */
    private static void demonstrateTask13() {
        System.out.println("=== ЗАВДАННЯ 13: intersect ===");
        
        Map<String, String> map1 = new HashMap<>();
        map1.put("Janet", "87");
        map1.put("Logan", "62");
        map1.put("Whitaker", "46");
        map1.put("Alyssa", "100");
        map1.put("Stefanie", "80");
        map1.put("Jeff", "88");
        map1.put("Kim", "52");
        map1.put("Sylvia", "95");
        
        Map<String, String> map2 = new HashMap<>();
        map2.put("Logan", "62");
        map2.put("Kim", "52");
        map2.put("Whitaker", "52");
        map2.put("Jeff", "88");
        map2.put("Stefanie", "80");
        map2.put("Brian", "60");
        map2.put("Lisa", "83");
        map2.put("Sylvia", "87");
        
        System.out.println("Мапа 1: " + map1);
        System.out.println("Мапа 2: " + map2);
        
        Map<String, String> intersection = ua.opnu.Task13.MapProcessor.intersect(map1, map2);
        System.out.println("Перетин: " + intersection);
        
        System.out.println();
    }

    /**
     * Демонстрація reverse (Завдання 14)
     */
    private static void demonstrateTask14() {
        System.out.println("=== ЗАВДАННЯ 14: reverse ===");
        
        Map<Integer, String> map = new HashMap<>();
        map.put(42, "Marty");
        map.put(81, "Sue");
        map.put(17, "Ed");
        map.put(31, "Dave");
        map.put(56, "Ed");
        map.put(3, "Marty");
        map.put(29, "Ed");
        
        System.out.println("Оригінальна мапа: " + map);
        
        Map<String, Integer> reversed = ua.opnu.Task14.MapProcessor.reverse(map);
        System.out.println("Реверсована мапа: " + reversed);
        
        System.out.println();
    }

    /**
     * Демонстрація rarest (Завдання 15)
     */
    private static void demonstrateTask15() {
        System.out.println("=== ЗАВДАННЯ 15: rarest ===");
        
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Alyssa", 22);
        map1.put("Char", 25);
        map1.put("Dan", 25);
        map1.put("Jeff", 20);
        map1.put("Kasey", 20);
        map1.put("Kim", 20);
        map1.put("Mogran", 25);
        map1.put("Ryan", 25);
        map1.put("Stef", 22);
        
        System.out.println("Мапа 1: " + map1);
        System.out.println("Найрідше значення: " + ua.opnu.Task15.MapProcessor.rarest(map1));
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Alyssa", 22);
        map2.put("Char", 25);
        map2.put("Dan", 25);
        map2.put("Jeff", 20);
        map2.put("Kasey", 20);
        map2.put("Kim", 20);
        map2.put("Mogran", 25);
        map2.put("Ryan", 25);
        map2.put("Stef", 22);
        map2.put("Kelly", 22);
        
        System.out.println("\nМапа 2: " + map2);
        System.out.println("Найрідше значення: " + ua.opnu.Task15.MapProcessor.rarest(map2));
        
        System.out.println();
    }

    /**
     * Демонстрація maxOccurrences (Завдання 16)
     */
    private static void demonstrateTask16() {
        System.out.println("=== ЗАВДАННЯ 16: maxOccurrences ===");
        
        List<Integer> list = Arrays.asList(9, 7, 9, -1, 2, 9, 7, 2, 15, 15);
        System.out.println("Список: " + list);
        System.out.println("Максимальна кількість входжень: " + ua.opnu.Task16.ListProcessor.maxOccurrences(list));
        
        System.out.println();
    }
}