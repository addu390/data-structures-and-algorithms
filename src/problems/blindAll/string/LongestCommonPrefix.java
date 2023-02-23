package problems.blindAll.string;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }

        for (int i = 0; i < strs[0].length(); i++) {
            int count = 0;
            int character = strs[0].charAt(i);
            for (String str: strs) {
                if (str.length() > i && str.charAt(i) == character) {
                    count = count + 1;
                }
            }

            if (count == strs.length) {
                result = strs[0].substring(0, i + 1);
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
