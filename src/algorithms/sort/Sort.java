package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

    public static void main(String[] args) {
        sort();
    }

    /**
     * Sorting in JAVA :
     * 1. Arrays.sort (User dual pivot quick sort) -> int[] ints
     * 2. Collections.sort (User tim sort - insertion + merge sort) (extends List interface) -> ArrayList, LinkedList, Vector etc.
     * We can also sort elements based on our own criteria - Implement comparator<Class> -> compare.
     * Compare function is java returns 3 values positive, negative or zero.
     */
    public static void sort() {

        int[] pivot = new int[]{ 10, 20, 40, 50, 6, 7, 8 };

        // Sorting sub-array of the given array.
        // Sorts elements from index 1 to index 5 - 1 (Yes, it's upto toIndex - 1)
        Arrays.sort(pivot, 1, 5);
        System.out.println(Arrays.toString(pivot));

        Arrays.sort(pivot);
        System.out.println(Arrays.toString(pivot));

        //Arrays.sort(pivot, Collections.reverseOrder());

        // Using Collections.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(9);
        Collections.sort(list);
        System.out.println(list);

        // Reverse order.
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
