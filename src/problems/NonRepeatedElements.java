package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatedElements {

    public static void main(String[] args) {

    }

    public static int countNonRepeated(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == 1) {
                count = count + 1;
            }
        }
        return count;
    }

    public static ArrayList<Integer> printNonRepeated(int arr[], int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list =  new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == 1) {
                list.add(e.getKey());
            }
        }
        return list;
    }
}
