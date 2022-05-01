package problems.leetcode;

public class Driver {

    public static void main(String[] args) {
        // A general tip to subtract with the start of the number '0' or the character 'a'
        // to get the offset, in other words the ith number or alphabet.
        char input = '5';
        int test = input - '0'; // 5

        /**
         *** Bucket Sort:
         * Index i represents the number and value represents the count.
         * This way, iterating the bucket sort-array gives the sorted array.
         * However, the catch is, the max number has to be known and the time complexity is O(max number);
         * Example: [1, 1, 1, 2, 2, 100] -> [0:0, 1:3, 2:2, 3:0, 4:0 ....... 99:0, 100:1]
         *
         *** Variation os Bucket Sort:
         * Index i represents the count and value is a list of numbers with that count.
         * Time complexity O(n) and this arrangement is used to get Top k frequent elements.
         * Example: [1, 1, 1, 2, 2, 100] -> [1:[100], 2:[2], 3:[1], 4:[], 5:[], 6:[]].
         * <count:List<Input Number>>
         */
    }
}
