package Introduction;

/**
 * Remember : Left shift of a small number, multiplies a number by 2 (8421)
 *
 * Basics :
 * In C++ there 6 bitwise operators
 * Let's start with AND (&), OR (|) and XOR (^)
 * AND : 1 when both the inputs are 1
 * OR : 1 when at-least one of the inputs are 1
 * XOR : 1 when the two input fields are different (01, 10)

 * Example :  3 & 6 = 2
 * 3 (00...0011)
 * 6 (00...0110)
 * Apply the BITWISE AND : 2 (00...0010)

 * Example : 3 | 6 = 2
 * 3 (00...0011)
 * 6 (00...0110)
 * Apply the BITWISE OR : 7 (00...0111)
 * To convert to decimal : Use the ..(32)(16)8421 rule.

 * Example : 3 ^ 6 = 5
 * 3 (00...0011)
 * 6 (00...0110)
 * Apply the BITWISE XOR : 5 (00...0101)

 * Left shift operator (<<), Right shift operator (>>), NOT operator.
 * This operation takes two inputs, the number to be shifted and the number of times it has to be shifted.
 * Example : 3 << 1 = 2
 * 3 (00...0011), 31 bits are are now shifted to the left, the first bit os ignored and a zero is added at the end.
 * Output : (00...0010) = 2
 * In simpler words, every shift corresponds to adding a trailing zero.
 * x << y = x * 2^y (Assuming the first y bits are zeroes and not 1s)

 * Right shift : Shifted towards the right, a leading zero is added and the trailing bit is ignored.
 * Example : 3 (00...0011) >> 1 = 1 (000...001)
 * 33 >>  1 : 16
 * x >> y = Floor(x/2^y) - we can use the right shift operator to divide the number with a power of 2 with floor value.

 * NOT Bitwise operator :
 * Unary operator : Inverts all the bits.
 * Example : (unsigned : Zero and positive) unsigned int X = 00...0001
 * (Considering 32 bits) - Max value is 2^32 - 1, considering 32 bits as max
 * ~X = (2^32 - 1) - Number.
 * ie ~5 is (2^32 - 1) - 5

 * Consider signed int, if the leading bit is 1 : Negative and if 0 : Positive.
 * Signed input (Considering 32 bits) : -2^31 to 2^31 - 1
 * To represent a negative : 1 followed by bit representation of the number (31 bits)
 * 2s compliment of x in n bits representation : 2^n - x
 * X = 5, 2^32 - 1 - 5 = 2^32 - 6 = -6
 * X = 1, 2^32 - 1 - 1 = 2^32 - 2 = -2
 * Generally not recommended to use << and >> for negative numbers.


 * Bitwise Operators in JAVA
 * Note : In java integers are represented with 32 bits.
 * In JAVA, negative numbers are stored in 2s compliment representation.
 * Representation of -x = 2^32 - x
 * Rule #1 : The leading bit is 1 -> Negative, The leading bit is 0 -> Positive.
 * 2^32 - 1 is 32 1s.
 *
 */
public class BitwiseOperators {

    /**
     * Example for bitwise NOT operation.
     * X = 5, ~X ?
     * X = 5 = 000.....0101
     * ~X = 11111.....1010
     * We know that 111...1111 = 2^32 - 1
     * Therefore, 11111.....1010 = 2^32 - 1 - 5 = 2^32 - 6
     * We know that : Representation of -x = 2^32 - x
     * ~X = ~5 = -6
     */
    public static void main(String[] args) {
        System.out.println(5 | 3);
        System.out.println(5 & 3);
        System.out.println(5 ^ 3);

        // Shift binary representation of 5 3 times towards the left.
        System.out.println(5 << 3);

        // Shift binary representation of 5 3 times towards the right.
        System.out.println(5 >> 3);

        /**
         * Note that while, shifting, we might get negative numbers.
         * 5 in binary format is : 000...0101
         * And after shifting 30 times, 10000....000
         * Since the leading bit is 1, it is a negative number.
         */
        System.out.println(5 << 3);

        /**
         * X = -1
         * Which is equivalent to 2^32 - 1 = 32 1s (1111....1111)
         * X << 1 (Left shift by 1) : 1111...1110 = 2^32 - 1 - 1 = -2
         */
        System.out.println(-1 << 1);

        /**
         * Right shift, is the opposite of left shift.
         * All bits after shifted, trailing bit is ignored and zero is added to the leading bit.
         * Let's consider an example for negative numbers.
         * 2 types : Signed and un-signed right shift.
         * Incase of negative numbers (2s compliment representation), right shift with adding a zero to leading bit,
         * will always result in a positive number, hence for negative numbers, we add 1 to the leading bit to preserve the sign.

         * Signed right shift :
         * Example : X = -2 = 2^32 - 2 = 2^32 - 1 - 1 = 111....1110
         * X >> 1 -> (1) 1111...111 -> For a negative number, the leading bit added is 1.
         * -2 >> 1 = (1) 1111...111 = 2^32 - 1 = -1
         * -2 >> 2 = -1

         * Un-signed right sift :
         * The only difference is that, for negative number, the leading bit added is always 0
         * Which means to say that the sign is not retained (Unlike signed right shift).
         * For positive numbers, signed and un-signed right shift will fetch the same result.
         */
        System.out.println(-2 >> 1);
        System.out.println(-2 >> 2);

        checkKthBit();
        setBitsCount(7);
        System.out.println(setBitsCountThree(7));

        initialize();
        int n = 9;
        System.out.println(countSetBits(n));

        System.out.println(powerOfTwo(4));
        System.out.println(powerOfTwo(6));
        oddAppearingNumberBruteForce();
        System.out.println(oddAppearingNumberXOR());
        System.out.println(findMissingNumber());
        twoOddAppearingNumbers();
        powerSet();
    }

    /**
     * Check if the kth bit of a given number is set (1)
     * Given a decimal, covert it to binary
     * Check if the kth bit is 1 or not.

     * Example : N = 5 and K = 1 -> 0000....0101
     * K = 1 corresponds to the last bit, which is 1 (SET) in this case

     * Solution : N = 5 and K = 3
     * Consider the number 5 : 0000....0101
     * Now consider : 1 << k-1 (Which is 1 << 3) : 0000...0100
     * 1 << k-1 will have only the kth element as 1 and all the rest as zero.
     * Therefore, if AND of N and (1 << k-1) is NOT Zero, then SET, else ZERO
     */
    public static void checkKthBit() {
        int n = 5;
        int k = 3;

        // Using left shift
        if ((n & (1 << k-1)) != 0) {
            System.out.println("SET");
        } else {
            System.out.println("NOPE");
        }

        // Using right shift
        if (((n >> (k-1)) & 1) == 1) {
            System.out.println("SET");
        } else {
            System.out.println("NOPE");
        }
    }

    /**
     * Count the number of bits set (1) of a given integer.
     * Example : N = 5 (000...0101)
     * Output : 2
     *
     * SOLUTION #1
     * The rudimentary way of solving this is :
     * Using right shift and performing AND with 1, until the number is ZERO.
     */
    static int count = 0;
    public static void setBitsCount(int n) {

        if (n == 0) {
            System.out.println(count);
            return;
        }
        if ((n & 1) != 0) {
            count++;
        }
        setBitsCount(n >> 1);
    }

    /**
     * Count the number of bits set (1) of a given integer.
     * Solution #2
     * In both Solution #1 and #2, the time taken is O(n)
     * Where n is the number of bits (32 bits)
     */
    public static int setBitsCountTwo(int n) {
        int count = 0;
        while (n != 0) {
            // Or n & 1 == 1 (As shown in the prior Solution #1)
            // To check if the last bit is set ot not : n % 2 != 0
            if (n % 2 != 0)
                count++;
            // To remove the last bit
            // Or use right shift as shown in Solution #1
            n = n/2;
        }
        return count;
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
     * Look up table
     * Time complexity :  Constant O(1)
     * Pre-processing :
     * 1. Divide the 32 bit number into 8 bit chunks,
     * we need a look-up table for number of SET bits for numbers from 0 to 255.
     */
    static int []table = new int[256];
    public static void initialize() {
        table[0] = 0;
        for (int i = 0; i < 256; i++)
        {
            // 5/2 (2) = 2; 7/4 (1.75) = 1
            table[i] = (i & 1) + table[i / 2];
        }
    }

    /**
     * Usage :
       initialize();
       int n = 9;
       System.out.println(countSetBits(n));
     */
    public static int countSetBits(int n)
    {
        // 0xff is 11111111
        return table[n & 0xff] +
                table[(n >> 8) & 0xff] +
                table[(n >> 16) & 0xff] +
                table[n >> 24];

        /**
         * Which is same as :
         int res = table[n & 0xff];
         n = n >> 8;

         res = res + table[n & 0xff];
         n = n >> 8;

         res = res + table[n & 0xff];
         n = n >> 8;

         res = res + table[n & 0xff];
         return res;
         */
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

    /**
     * Given a list, where every number appears even number of times, except one number (Appears odd times), find it!
     * Example : [1, 1, 3, 3, 3, 4, 4, 4, 5, 5, 4]
     * Output : 3

     * The brute force approach is with O(n^2) to traverse the entire array for each element
     */
    public static void oddAppearingNumberBruteForce() {
        int[] ints = new int[5];
        ints[0] = 1;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 3;

        for (int i = 0 ; i < ints.length; i++) {
            int count = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == ints[i]) {
                    count++;
                }
            }
            if ((count % 2) != 0) {
                System.out.println(ints[i]);
            }
        }

    }

    /**
     * The prior approach took a complexity of O(n^2)
     * We can solve this using XOR, properties of XOR :
     * 1. X ^ 0 = X
     * 2. X ^ Y = Y ^ X
     * 3. X ^ (Y ^ Z) = (Y ^ X) ^ Z
     * 4. X ^ X = 0
     * Now, but taking XOR of all numbers, even numbers cancel because of X ^ X = 0
     * And the odd number is left out because of X ^ 0 = X
     * Time complexity of this approach using XOR is O(n)
     */
    public static int oddAppearingNumberXOR() {
        int[] ints = new int[5];
        ints[0] = 1;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 3;

        int number = ints[0];
        for (int i = 1; i < ints.length; i++) {
            number = (number ^ ints[i]);
        }
        return number;

    }

    /**
     * For given value of n, there are 1 to n+1 consecutive number.
     * In this array, one of the numbers is numbers - Find it!
     * Example : Input : [1, 3, 4]
     * Output : 2
     * Solution : Since we know the value of n, XOR all the elements that are supposed to be there,
     * with the given list, that way, only the missing element will be left out.
     * Based on properties :
     * 1. X ^ X = 0
     * 2. X ^ 0 = X
     */
    public static int findMissingNumber() {
        int n = 5;
        int[] ints = new int[5];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 4;
        ints[3] = 5;

        int number = 0;
        for (int i = 1; i <= n; i++) {
            number = number ^ (i ^ ints[i-1]);
        }
        System.out.println(2^4);
        return number;
    }

    /**
     * Similar question : Every integer in the array appears even number of times,
     * except 2 integers, which appear odd number of times.
     * Input : [1, 2, 1, 3, 3, 4, 4, 4]
     * Output : [2, 4]

     * Solution with O(n^2)
     * Traverse the entire array for every element, if the count is odd,
     * Add it to the new array (Output).

     * Solution with O(n) :
     * Step 1 : FInd XOR of all the elements (Result is XOR of two odd appearing numbers) -> 2 ^ 4
     * 2 ^ 4 = 6 (0110), for XOR, we know that it is 1 if for (10) or (01)
     * Therefore, split the given list into 2 lists, such that first list has SET bit in 2nd position as 1
     * Second list where SET bit in 2nd position as 0, (Consider the last SET bit).
     * Now take the XOR of both of these lists separately and you get those 2 numbers.
     */
    public static void twoOddAppearingNumbers() {
        int[] ints = new int[6];
        ints[0] = 1;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 2;
        ints[5] = 3;

        int xor = 0;
        for (int i = 0; i < ints.length; i++) {
            xor = xor ^ ints[i];
        }
        // Find right most SET bit.
        /**
         * We known from (n-1) turns off the last SET bit and all zeroes after that as 1s
         * Now ~(n-1) will turn on the last SET bit and all terms before that are inverted,
           On taking AND, only the last SET bit is let out.
         * Last SET bit of n and ~(n - 1) will be the same, all the others will be different.
         */
        int rightMostSet = xor & (~(xor - 1));

        int numberOne = 0;
        int numberTwo = 0;
        for (int i = 0; i < ints.length; i++) {
            if ((ints[i] & rightMostSet) != 0) {
                numberOne = numberOne ^ ints[i];
            } else {
                numberTwo = numberTwo ^ ints[i];
            }
        }
        System.out.println(String.format(Integer.toString(numberOne) + " and " +  Integer.toString(numberTwo)));
    }

    /**
     * Input : "abc"
     * Output : "", "a", "b", "c", "ab", "ac", "bc", "abc"
     * For n strings, there are 2^n - 1 (subset) possibilities.
     * Varies from 0 to 2^n - 1

     * Solution :
     * We know that there 2^n possibilities, consider "abc" -> 2^3 = 8
        000 = ""
        001 = "c"
        010 = "b"
        011 = "bc"
        100 = "a"
        101 = "ac"
        110 = "ab"
        111 = "abc"
     * Solution: For loop from 0 to 2^n - 1
     * Nested loop with n, find if the kth bit is SET or not (Refer above in the same class)
     * If SET, add the string, repeated for all 2^8 possible values.
     * Time complexity : 2^n * n
     */
    public static void powerSet() {
        String text = "abcd";
        int n = (int) Math.pow(2, text.length());
        String[] strings = text.split("");

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < strings.length; j++) {
                if (((i >> strings.length - j - 1) & 1) == 1) {
                    temp = temp + strings[j];
                }
            }
            System.out.println(temp);
        }
    }


}
