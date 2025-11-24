package ua.opnu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            if (i + 1 < list.size()) {
                String first = list.get(i);
                String second = list.get(i + 1);
                if (first.length() <= second.length()) {
                    list.remove(i);
                    i--;
                } else {
                    list.remove(i + 1);
                    i--;
                }
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        
        for (int i = 0; i < size / 2; i++) {
            stack.push(queue.poll());
        }
        
        if (size % 2 == 1) {
            queue.poll();
        }
        
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        
        return true;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> temp = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        
        Collections.sort(temp);
        
        for (Integer num : temp) {
            queue.offer(num);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> odds = new ArrayDeque<>();
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.offer(num);
            } else {
                odds.offer(num);
            }
        }
        
        while (!odds.isEmpty()) {
            queue.offer(odds.poll());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
        
        int minCount = Integer.MAX_VALUE;
        int rarest = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (count < minCount || (count == minCount && value < rarest)) {
                minCount = count;
                rarest = value;
            }
        }
        
        return rarest;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : list) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        return Collections.max(counts.values());
    }

}
