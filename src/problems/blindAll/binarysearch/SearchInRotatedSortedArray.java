package problems.blindAll.binarysearch;

public class SearchInRotatedSortedArray {

    // Sorted and rotated can have 2 sorted portion, find the sorted portion.
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target == nums[left]) {
                return left;
            }

            if (target == nums[right]) {
                return right;
            }

            if (nums[mid] >= nums[left]) {
                // Left is Sorted portion
                if (target < nums[mid] && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
