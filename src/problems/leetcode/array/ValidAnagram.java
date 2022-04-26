package problems.leetcode.array;

import java.util.HashMap;
import java.util.Map;

// <Class name>::<method name>
// An other solution without extra space: Sort the two strings and compare.
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(s.charAt(i), 1, Integer::sum);
        }

        for (Character character: sMap.keySet()) {
            if (!sMap.get(character).equals(tMap.get(character))) {
                return false;
            }
        }
        return true;
    }
}
