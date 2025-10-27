package org.example.Task6;

import java.util.Comparator;

public class LastNameSorter implements Comparator {
    private boolean ascending;

    public LastNameSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            
            if (ascending) {
                return s1.getLastName().compareTo(s2.getLastName());
            } else {
                return s2.getLastName().compareTo(s1.getLastName());
            }
        }
        return 0;
    }
}