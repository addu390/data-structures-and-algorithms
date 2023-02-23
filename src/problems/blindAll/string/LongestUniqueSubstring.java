package problems.blindAll.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstring {

    public static int longestUniqueSubString(String str) {
        String result = "";
        char[] chars = str.toCharArray();

        int max = Integer.MIN_VALUE;

        if (str.isEmpty()) {
            return 0;
        } else if (str.length() == 1) {
            return 1;
        }

        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(chars[i]);

            if (result.contains(temp)) {
                result = result.substring(result.indexOf(temp) + 1);
            }

            result = result + chars[i];
            max = Math.max(result.length(), max);

        }
        return max;
    }

    public static String longestSubstringWithKUniqueCharacters(String str, int k) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int[] max = new int[]{0, 0};

        Set<Character> set = new HashSet<>();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int left = 0, right = 0; right < str.length(); right++) {
            set.add(str.charAt(right));
            frequencyMap.merge(str.charAt(right), 1, Integer::sum);

            while (set.size() > k) {
                frequencyMap.merge(str.charAt(left), -1, Integer::sum);

                if (frequencyMap.containsKey(str.charAt(left)) && frequencyMap.get(str.charAt(left)) == 0) {
                    frequencyMap.remove(str.charAt(left));
                    set.remove(str.charAt(left));
                }
                left = left + 1;
            }

            if (right - left > max[1] - max[0]) {
                max[0] = left;
                max[1] = right;
            }
        }

        return str.substring(max[0], max[1] + 1);
    }

    public static void main(String[] args) {
        System.out.print(longestUniqueSubString("aaaaaaab"));
        System.out.print(longestSubstringWithKUniqueCharacters("abcbdbdbbdcdabd", 2));
    }
}
