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
}
