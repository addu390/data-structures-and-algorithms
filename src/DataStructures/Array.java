package DataStructures;

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
            System.out.println(ints[i]);
        }
    }
}
