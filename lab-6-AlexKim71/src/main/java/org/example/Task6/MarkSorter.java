package org.example.Task6;

import java.util.Comparator;

public class MarkSorter implements Comparator {
    private boolean ascending;

    public MarkSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            
            if (ascending) {
                return Double.compare(s1.getAvgMark(), s2.getAvgMark());
            } else {
                return Double.compare(s2.getAvgMark(), s1.getAvgMark());
            }
        }
        return 0;
    }
}