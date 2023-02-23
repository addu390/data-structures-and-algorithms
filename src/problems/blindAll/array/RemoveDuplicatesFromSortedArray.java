package problems.blindAll.array;

public class RemoveDuplicatesFromSortedArray {

    // [1,1,2]
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int index = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                nums[index] = nums[i];
                current = nums[i];
                index = index + 1;
            }
        }
        return index;
    }
}
