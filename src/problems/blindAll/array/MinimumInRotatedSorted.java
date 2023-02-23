package problems.blindAll.array;

public class MinimumInRotatedSorted {

    // 2 sorted portions (both in ascending order).
    // When nums[mid] >= nums[left] -> The bigger portion is on the left, choose right.
    public int findMin(int[] nums) {

        int result = nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Array is already sorted
            if (nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = (left + right)/2;
            result = Math.min(result, nums[mid]);

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }
}
