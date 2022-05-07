package problems.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Input: ["neet", "code"]
    // Hash: 4#neet4#code
    // Read the integer, get the next 'n' characters and repeat, does not matter what the input string contains.
    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        if (strs.size() == 0) {
            return "";
        }

        for (String str: strs) {
            builder.append(str.length()).append("#").append(str);
        }

        return builder.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.isEmpty()) {
            return result;
        }

        int index = 0;
        while (index < str.length()) {
            int length = Integer.parseInt(String.valueOf(str.charAt(index)));
            result.add(str.substring(index + 2, index + 2 + length));

            index = index + length + 2;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(encode(Arrays.asList("neet", "codes")));
        System.out.print(decode("4#neet5#codes"));
    }
}
