package problems.leetcode.string;

public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        char c = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == c && i + needle.length() <= haystack.length() ) {
                int j = i + 1, k=1;
                boolean isMatch = true;

                while (k < needle.length()) {
                    if (haystack.charAt(j++) != needle.charAt(k++)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr("mississippi", "issip");
    }
}