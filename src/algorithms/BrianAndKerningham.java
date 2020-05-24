package algorithms;

/**
 * Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1)
 * including the rightmost set bit.
 *
 * In a nutshell, the rule to remember :
 * n-1 : The last SET bit is 0 and all the zeroes after it are 1.
 * n & (n-1) : Will turn off the last SET bit, repeating this turn off all SET bits, eventually ZERO.
 *
 */
public class BrianAndKerningham {

    public static void main(String[] args) {
        System.out.println(setBitsCountThree(5));
        System.out.println(powerOfTwo(5));
    }

    /**
     * Solving using : Brian and Kerningham Algorithm
     * Also refer : Algorithms : BrianAndKerningham.java
     * Time complexity is equal to the number of set bits.
     *
     * Expression n = (n & (n-1))
     * Note : When you subtract 1 from a number, all the zeroes from the last SET bit become 1
     * And the last SET bit becomes 0 from 1
     * Example : 40 (101000) and 39 (100111)
     * Now performing (n & (n-1)), in very iteration, you are turning off the last SET bit.
     * Hence, the time complexity O(Number of SET bits).
     */
    public static int setBitsCountThree(int n) {
        int res = 0;
        while (n > 0) {
            n = (n & (n-1));
            res++;
        }
        return res;
    }

    /**
     * To check if a number is power of 2 or not.
     * Example : 4 (YES), 6 (NO)
     * Solution #1 : Divide the number by 2 until it's 1 (YES) or an odd number (NO)
     * ODD : If ((n % 2) != 0)

     * Solving with Brian and Kerningham Algorithm
     * Note : The powers of two always has only one SET bit.
     * So if n & (n-1) is Zero, the number os a power of TWO
     */
    public static boolean powerOfTwo(int n) {
        boolean isPower = false;
        if ((n & (n-1)) == 0) {
            isPower = true;
        }
        return isPower;
    }
}
