package DataStructures;

/**
 * a = [1, 3, 5, 7]
 * Advantages: Random access : a[0] -> O(1)
 * (Fastest memory and ideally would want all data in cache) Cache friendliness :
 * What happens in cache? near by items are pre-fetched, meaning when you access a[2],
 * near by items are more likely to be pre-fetched to cache.

 * Other data stored used to store a group such as linkedList does not store data in contiguous block
 * (Hence pre-fetching is not possible)

 * Types of arrays (Although there are many ways of categorising array)
 * 1. Fixed sized array :
 * 2. Dynamic sized array : Automatically resize array while adding more items.

 * Fixed sized array :
 * (Memory allocation can be : Stack allocated and heap allocated) - C++
 * Where as in Java, arrays are always heap allocated. (Example : int[] arr = new int[100], int arr[] = [1, 4, 6, 7])

 * Dynamic sized array : example -> ArrayList in java, Vector in C++, List in python.
 * They resize themselves dynamically.
 * Resizing can differ based on implementation, example is that the default size is 10,
 * When it is full, it is resized to 20, by creating a new array of size 20 and copying 10 elements of the older to new.]
 * It is recommended to use dynamic sized arrays, because they can be used as fixed sized arrays,
 * when array is not going to get resized and a lot more built-in methods.

 * Operations on array :
 * 1. Search : Given an array, find if x is present in the array -> O(n)
 * Commonly used searching algorithms : Binary search can search an item in an array in O(log n) and Linear search O(n)
 * (Refer : Algorithms/Search)
 * 2. Insert : (In a fixed array, item cannot be inserted if it's full).
 * Complexity : O(n), best case is when the item is inserted at the last (O(1)).
 * But if an item is to be inserted to the first (O(n)) other places, trailing items are to be shifted.
 * Average time complexity even for dynamic arrays to insert to the end is still O(1)
 * Add operation in ArrayList of java inserts an item to the end.
 * 3. Remove/ Delete : To delete an item, shift the elements, resulting in having an extra space.
 * Complexity : O(n), but O(1) for deleting the last element or known index.
 * Update : Getting and updating ith element in an array is always O(1) -> Random access.
 */
public class Array {

    /**
     * Basics of array :
     * 1. All the elements of an array are stored as one contiguous block in memory.
     *    This is also the reason why the size of the array has to be pre-defined and also why it is not dynamic,
     *    as there is no guarantee that memory will available as a contiguous block later on to re-size.
     *
     * 2. Every element in the array occupies the same amount of memory (Example int is 4 bytes).
     *    Different items in the array cannot occupy different amount of memory.
     *
     *    Note : that in-case of Objects, what is stored in the array is an object reference and nit the Object itself.
     *
     * 3. Time complexity for operations on an Array :
     *    a. To retrieve the element for a given index : O(1) - Constant time complexity.
     *
     *    b. To retrieve the element without knowing index : O(n) - Linear time complexity.
     *
     *    c. Add an element to a full array : Since we known that arrays are not dynamic,
     *      the only was is to create a branch new array and copy the elements - O(n)
     *
     *    d. Add an element to an array which has space - O(1)
     *
     *    e. Delete an element by shifting elements - O(n)
     *          ie, if we delete the first element, all the other elements has to be shifted down.
     */
    public static void main (String[] strings) {
        /**
         * Arrays are "not dynamic" in nature, meaning in this case the size of the array is 7
         * The size can neither be decreased nor be increased.
         */

        int[] ints = new int[7];

        ints[0] = 1;
        ints[1] = -1;
        ints[2] = -4;
        ints[3] = 44;
        ints[4] = 32;
        ints[5] = 12;
        ints[6] = -11;

        /**
         * ints.length is the number of elements that the array can hold,
         * In this case ints.length is 7
         * And hence the for loop has to stop when length is less than 7 (max of 6)
         * Or you can write i <= ints.length - 1
         */

        for (int i = 0; i < ints.length; i++) {
            //System.out.println(ints[i]);
        }

        reverseArray(ints);

        int[] intArray = new int[]{ 1, 1, 2, 2, 2, 4, 5 };
        System.out.println("Size of the distinct array : " + removeDuplicates(intArray));
        System.out.println("Size of the distinct array : " + removeDuplicatesTwo(intArray));

        int[] left = new int[]{ 1, 2, 3, 4, 5};
        leftRotate(left);

        int[] leftD = new int[]{ 1, 2, 3, 4, 5};
        leftRotate(leftD, 3);

        int[] rev = new int[]{ 1, 2, 3, 4, 5};
        leftRotateAux(rev, 2);

        int[] lead = new int[]{ 7, 10, 4, 3, 6, 5, 2 };
        arrayLeader(lead);

        int[] max = new int[]{ 2, 1, 10, 0, 6, 4 };
        System.out.println("Max difference : " + maxDifference(max));
        System.out.println("Max difference : " + maxDifferenceTwo(max));
    }

    /**
     * Input : [1, 2, 3]
     * Output : [3, 2, 1]
     * Note that we have to modify the same array.
     *
     * First approach we can think of is SWAP.
     * Time complexity is O(n/2) = O(n)
     */
    public static int[] reverseArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (i == ints.length / 2) {
                break;
            }
            int temp = ints[i];
            ints[i] = ints[ints.length - 1 - i];
            ints[ints.length - 1 - i] = temp;
        }
        return ints;
    }

    /**
     * Remove duplicates from sorted array.
     * Ensure that the distinct elements are in first positions.
     * Example : [10, 20, 20, 30, 30, 30]
     * Output : [10, 20, 30] with size of 3.
     * Time complexity : O(n)
     * Auxiliary space : O(n) - Since a temporary array is used.
     */
    public static int removeDuplicates(int[] ints) {
        int[] temp = new int[ints.length];
        temp[0] = ints[0];
        int count = 1;

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i + 1] > ints[i]) {
                temp[count] = ints[i + 1];
                count = count + 1;
            }
        }

        // Copy contents of temp to the original array.
        for (int i = 0; i < ints.length - 1; i++) {
            ints[i] = temp[i];
        }
        return count;
    }

    /**
     * Remove duplicates from sorted array.
     * Same problem without using a temporary array.
     * Time complexity : O(n)
     * Auxiliary space : O(1)
     */
    public static int removeDuplicatesTwo(int[] ints) {
        int newIndex = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > ints[i - 1]) {
                newIndex = newIndex + 1;
                ints[newIndex] = ints[i];
            }
        }
        return newIndex;

    }

    /**
     * Left rotate an array by one.
     * Example : [1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1]
     */
    public static int[] leftRotate(int[] ints) {

        int temp = ints[0];
        for (int i = 1; i < ints.length; i++) {
            ints[i - 1] = ints[i];
        }
        ints[ints.length - 1] = temp;
        return ints;

    }

    /**
     * Left rotate by D places.
     * Considering that the left rotate by 1 is already done, calling it d times solves the problem.
     * Complexity : O(n * d), but Auxiliary space is O(1)
     * Example : [1, 2, 3, 4, 5], d = 2 -> [3, 4, 5, 1, 2]
     * Complexity : O(n)
     * Auxiliary space : O(d)
     */
    public static int[] leftRotate(int[] ints, int d) {

        // Temporarily store the first "d" numbers.
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = ints[i];
        }

        // Do left shift by d.
        for (int i = d; i < ints.length; i++) {
            ints[i - d] = ints[i];
        }

        // Replace the last d numbers by values in temp
        int counter = ints.length - 1;
        for (int i = d - 1; i >= 0; i--) {
            ints[counter] = temp[i];
            counter = counter - 1;
        }
        return ints;
    }


    /**
     * By looking at the pattern : [1, 2, 3, 4, 5]
     * 1. Reverse the first d elements : [2, 1, 3, 4, 5]
     * 2. Reverse the rest of the elements : [2, 1, 5, 4, 3]
     * 3. Reverse the entire array : [3, 4, 5, 1, 2]
     * Complexity : O(n)
     * Auxiliary space : O(1)
     */
    public static int[] leftRotateAux(int[] ints, int d) {
        // 1. Reverse the first d elements : [2, 1, 3, 4, 5]
        reverse(ints, 0, d - 1);

        // 2. Reverse the rest of the elements : [2, 1, 5, 4, 3]
        reverse(ints, d, ints.length - 1);

        // 3. Reverse the entire array : [3, 4, 5, 1, 2]
        reverse(ints, 0, ints.length - 1);
        return ints;
    }

    // 1 2 3 4 5
    public static void reverse(int[] ints, int n, int k) {
        for (int i = n; i < k; i++) {
            int temp = ints[i];
            ints[i] = ints[k];
            ints[k] = temp;
            k = k - 1;
        }
    }

    /**
     * What is a leader : An element is a leader, when elements towards the right of it is smaller than it.
     * Example : [7, 10, 4, 3, 6, 5, 2]
     * Leaders : 10, 6, 5, 2 (Last element is always a leader).
     * Sorted array in descending order, all elements are leaders except last element.
     * Sorted array in ascending order, none of the elements are leaders.
     * The obvious way of solving is O(n^2), for each element check if there is any element greater than it on the right.
     * The O(n) solution is to start from the last and compare with previous term.
     */
    public static void arrayLeader(int[] ints) {
        int max = ints[ints.length - 1];
        System.out.println("Leader : " + max);
        for (int i = ints.length - 1; i > 0; i--) {
            if (ints[i - 1] > max) {
                System.out.println("Leader : " + ints[i - 1]);
                max = ints[i - 1];
            }
        }
    }

    /**
     * Given an array of integers, find the max difference.
     * Example : [2, 3, 10, 6, 4]
     * Output : 10 - 2 = 8
     * In simple words, find smallest and largest number and return the difference.
     * Time complexity : O(n)
     * Auxiliary space : O(1)
     */
    public static int maxDifference(int[] ints) {

        int max = ints[0];
        int min = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
            if (ints[i] < min) {
                min = ints[i];
            }
        }
        return max - min;

    }

    /**
     * Given an array of integers, find the max difference. arr[j] - arr[i]
     * Such that j > i
     * Smaller term has to be before larger term.
     * The brute force solution is O(n^2)
     * Example : [2, 1, 10, 6, 4]
     * Output : 10 - 1 = 9
     */
    public static int maxDifferenceTwo(int[] ints) {

        int min = ints[0];
        int diff = ints[1] - ints[0];
        for (int i = 1; i < ints.length; i++) {
            min = Math.min(ints[i], min);
            if ((ints[i] - min) > diff) {
                diff = ints[i] - min;
            }
        }
        return diff;
    }
}
