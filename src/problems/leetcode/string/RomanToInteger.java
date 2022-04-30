package problems.leetcode.string;

import java.util.HashMap;

// Assuming that the input roman is valid.
public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + map.get(s.charAt(i));

            if ((i > 0) && (map.get(s.charAt(i - 1)) < map.get(s.charAt(i)))) {
                sum = sum - (map.get(s.charAt(i - 1)) * 2);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IIIV"));
    }
}
