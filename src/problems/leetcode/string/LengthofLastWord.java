package problems.leetcode.string;

public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        lengthOfLastWord("   fly me   to   the moon  ");
    }
}
