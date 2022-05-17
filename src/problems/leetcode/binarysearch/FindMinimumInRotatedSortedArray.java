package problems.leetcode.binarysearch;

// 1 2 3 4 5-> 3 4 5 1 2
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int mid = (left + right)/2;
            min = Math.min(min, nums[mid]);
            min = Math.min(min, nums[left]);

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }
}
