package problems;

import problems.classes.ListNode;

import java.util.*;

public class Leetcode {

    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3}, 2));
    }


    public static int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return tribo(n, map);
    }

    public static int[] sortedSquares(int[] nums) {
        if (nums[0] > 1) {
            return nums;
        }

        int negativeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                negativeIndex = negativeIndex + 1;
            }
        }
        int postiveIndex = nums.length - negativeIndex;

        int[] negativeArray = new int[negativeIndex];
        int[] positiveArray = new int[postiveIndex];

        for (int j = 0; j < negativeIndex; j++) {
            negativeArray[j] = nums[nums.length - 1 - postiveIndex - j];
        }

        for (int k = 0; k < postiveIndex; k++) {
            positiveArray[k] = nums[negativeIndex + 1 + k];
        }
        return mergeSortedArrays(positiveArray, negativeArray);
    }

    public static int maxDifference(int[] nums) {
        int min = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - min);
            min = Math.min(min, nums[i]);
        }

        return max;
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length - 1];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i <= a.length && j <= b.length) {
            if (a[i] >= b[j]) {
                c[k] = b[j];
                j = j + 1;
            } else {
                c[k] = a[j];
                i = i + 1;
            }
        }

        while (i < a.length) {
            c[k] = a[i];
            k = k + 1;
            i = i + 1;
        }

        while (j < b.length) {
            c[k] = b[j];
            k = k + 1;
            j = j + 1;
        }
        return c;
    }

//    public int firstBadVersion(int n) {
//        int start = 0;
//        int end = start + ((n - start)/2);
//
//        while (start < end) {
//            boolean currentVersion = isBadVersion(end);
//            boolean previousVersion = isBadVersion(end - 1);
//            if (currentVersion == true && previousVersion == false) {
//                return end;
//            }
//            if (currentVersion) {
//                 end = start + ((end - start)/2);
//            } else {
//                start = end;
//                end = n;
//            }
//        }
//        return -1;
//    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int length = nums.length;
        int end = start + ((length - start)/2);

        if (target < nums[0]) {
            return 0;
        }

        if (target > nums[length - 1]) {
            return length;
        }

        while (start <= end) {
            if (target == nums[end]) {
                return end;
            }

            if (target == nums[start]) {
                return start;
            }

            if (target < nums[end]) {
                start = start + ((end - start)/2);
            }

            if (target > nums[end]) {
                start = end;
                end = start + ((length - start)/2);;
            }

            if (end - start == 1) {
                break;
            }
        }
        if (target > start) {
            return start + 1;
        }

        if (target < end) {
            return end - 1;
        }

        return start;
    }

    public int climbStairs(int n) {
        int twos = n / 2;
        int ones = n - twos;

        return (int) (Math.pow(2, twos) * Math.pow(2, ones));
    }

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            start = start + 1;
            end = end - 1;

        }
        return -1;
    }

    public static int tribo(int n, Map<Integer, Integer> map) {
        if (n == 0) {
            return 0;
        }

        if ((n == 1) || (n == 2)) {
            return 1;
        }
        int a = map.containsKey(n - 3) ? map.get(n - 3) : tribo(n - 3, map);
        int b = map.containsKey(n - 2) ? map.get(n - 2) : tribo(n - 2, map);
        int c = map.containsKey(n - 1) ? map.get(n - 1) : tribo(n - 1, map);

        map.put(n - 3, a);
        map.put(n - 2, b);
        map.put(n - 1, c);
        return a + b + c;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int  i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int localSum = nums[i];
            maxSum = Math.max(maxSum, localSum);
            for (int j = i + 1; j < nums.length; j++) {
                localSum = localSum + nums[j];
                maxSum = Math.max(maxSum, localSum);
            }
        }

        return maxSum;

    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int area = 0;

        while (start < end) {
            area = Math.max(area, height[end] * (end - start));
            if (height[start] < height[end]) {
                start = start + 1;
            } else {
                end = end - 1;
            }
        }

        return area;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                start = start + 1;
            }

            if (sum > target) {
                end = end - 1;
            }
        }

        return new int[]{map.get(nums[start]), map.get(nums[end])};

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode lengthHead = head;
        while (Objects.nonNull(lengthHead.next)) {
            length = length + 1;
            lengthHead = lengthHead.next;
        }

        if (length == 1) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int i = 0; i < length - n; i++) {
            head = head.next;
        }

        if (Objects.nonNull(head) && Objects.nonNull(head.next)) {

        }
        ListNode remove = head.next;
        head.next = remove.next;
        return dummy.next;
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
