package problems.blindAll.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * O(Number of input strings * Average length of a string * 26) = O(m * n)
 */

// Note: subtracting 'a' from the value of c will give its offset from the beginning of the alphabet
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        if (strs.length == 0) {
            return result;
        }

        for (String str: strs) {
            char[] hash = new char[26]; // 26 lowercase characters.

            // eat and tea stored as "aet" - a common hash for anagrams.
            for (char c: str.toCharArray()) {
                hash[c - 'a']++;
            }

            String hashString = new String(hash);

            if (map.get(hashString) == null) {
                map.put(hashString, new ArrayList<>());
            }

            // Group anagrams.
            map.get(hashString).add(str);
        }
        // Convert map to list<List<String>>.
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
