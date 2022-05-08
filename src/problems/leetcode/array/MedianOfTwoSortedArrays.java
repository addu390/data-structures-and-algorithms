package problems.leetcode.array;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] sorted = new int[length];

        int counter1 = 0;
        int counter2 = 0;

        int index = 0;

        while (counter1 < nums1.length && counter2 < nums2.length) {
            if (nums1[counter1] <= nums2[counter2]) {
                sorted[index] = nums1[counter1];
                counter1 = counter1 + 1;
            } else {
                sorted[index] = nums2[counter2];
                counter2 = counter2 + 1;
            }

            index = index + 1;
        }

        if (counter1 < nums1.length) {
            for (int i = counter1; i < nums1.length; i++) {
                sorted[index] = nums1[i];
                index = index + 1;
            }
        }

        if (counter2 < nums2.length) {
            for (int i = counter2; i < nums2.length; i++) {
                sorted[index] = nums2[i];
                index = index + 1;
            }
        }

        // even
        if (sorted.length % 2 == 0) {
            return (sorted[sorted.length/2] + sorted[sorted.length/2 - 1])/2.0;
        } else {
            return sorted[sorted.length/2];
        }
    }

    public static void main(String[] args) {
        System.out.print(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
