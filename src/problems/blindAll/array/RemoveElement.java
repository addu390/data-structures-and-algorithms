package problems.blindAll.array;

public class RemoveElement {

    // [3,2,2,3], val = 3
    public static int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index = index + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3}, 3);
    }
}
