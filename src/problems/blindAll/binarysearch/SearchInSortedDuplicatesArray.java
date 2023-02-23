package problems.blindAll.binarysearch;

public class SearchInSortedDuplicatesArray {
    public static int firstOccurrence (int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = left + (right - left)/2;

            if (array[mid] == target) {
                if (mid - 1 >= 0 && array[mid - 1] == target) {
                    right = mid - 1;
                    continue;
                }
                return mid;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int lastOccurrence (int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (array[mid] == target) {
                if (mid+1 < array.length && array[mid+1] == target) {
                    left = mid + 1;
                    continue;
                }
                return mid;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 9, 9, 9, 9, 10, 10, 12, 13 };
        System.out.print(firstOccurrence(array, 2));
        System.out.print(lastOccurrence(array, 9));
    }
}
