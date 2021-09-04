package problems;

import problems.classes.ListNode;

import java.util.HashSet;

public class Leetcode {

    public static void main(String[] args) {

        int[] intA = new int[]{1, 3};
        int[] intB = new int[]{2, 4};
        System.out.println(longestPalindrome("ccc"));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedArray = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sortedArray[k] = nums1[i];
                k = k + 1;
                i = i + 1;
            }
            else {
                sortedArray[k] = nums2[j];
                k = k + 1;
                j = j + 1;
            }
        }

        while (i < nums1.length) {
            sortedArray[k] = nums1[i];
            k = k + 1;
            i = i + 1;
        }

        while (j < nums2.length) {
            sortedArray[k] = nums2[j];
            k = k + 1;
            j = j + 1;
        }

        int a = sortedArray.length / 2;
        if (((sortedArray.length) % 2) == 0) {
            return (sortedArray[a - 1] + sortedArray[a])/2.0;
        } else {
            return sortedArray[a];
        }
    }

    public static void test() {
        System.out.println(3 % 10);
        System.out.println(90909 / 10);
    }

    // "babad"
    public static String longestPalindrome(String s) {
        String[] stringArray = s.split("");
        String maxResult = "";

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < stringArray.length - 1; i++) {
            String stringOne = expandCentre(stringArray, i, i);
            String stringTwo = expandCentre(stringArray, i, i + 1);

            if (stringOne.length() > maxResult.length()) {
                maxResult = stringOne;
            }

            if (stringTwo.length() > maxResult.length()) {
                maxResult = stringTwo;
            }
        }

        return maxResult;
    }

    public static String expandCentre(String[] inputArray, int left, int right) {
        String result = "";
        if (left == right) {
            result = inputArray[left];
        } else {
            if (inputArray[left].equals(inputArray[right])) {
                result = inputArray[left].concat(inputArray[right]);
            } else {
                return result;
            }
        }
        left--;
        right++;
        if (left < 0) {
            return result;
        } else {
            while (left >= 0 && right < inputArray.length) {
                if (inputArray[left].equals(inputArray[right])) {
                    result = inputArray[left].concat(result).concat(inputArray[right]);
                    left--; right++;
                } else {
                    break;
                }
            }
        }
        return result;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * Asymptotic Notations.
     * For the input size, how does the algorithm grow?
     * Does not depend on the programming language or resources.
     * And don't have to implement!
     *
     * n: Linear
     * n^2: Quadratic
     * c < log log n < log n < n^(1/3) < n^(1/2) < n < n^2 < n^3 ...
     */
    public static int sumofnumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static boolean findElement(int[] ints, int start, int end, int element) {
        if (ints[start] == element) {
            return true;
        }

        if (ints[end] == element) {
            return true;
        }

        if (start > end) {
            return false;
        }

        return findElement(ints, start + 1, end - 1, element);
    }

    public static int lengthOfLongestSubstring(String s) {
        String[] strings = s.split("");
        if (s.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            int tempmax = 0;
            HashSet<String> hashset = new HashSet<>();
            for (int j = i; j < strings.length; j++) {
                if (hashset.contains(strings[j])) {
                    hashset.clear();
                    max = Math.max(max, tempmax);
                    break;
                } else {
                    hashset.add(strings[j]);
                    tempmax = tempmax + 1;
                    max = Math.max(max, tempmax);
                }
            }
        }
        return max;
    }
}
