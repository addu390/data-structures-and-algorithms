package problems.blindAll.string;

import java.util.HashMap;
import java.util.Map;

// <Class name>::<method name>
// An other solution without extra space: Sort the two strings and compare.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.

// Same set of characters.
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        // Character, Count
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
