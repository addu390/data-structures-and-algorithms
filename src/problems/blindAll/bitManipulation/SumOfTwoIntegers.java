package problems.blindAll.bitManipulation;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1; // a and b and shift it to left by 1 (because carry doesn't come on unit place)
            a = (a ^ b); // xor (11 is 0, 10 or 01 is 1, 00 is 0)
            // xor doesn't take care of the carry
            b = tmp;
        }
        return a;

        // example: 9 + 11
        // x = a^b = 0010
        // a & b = 1001
        // y = a & b >> 1 = 10010
    }
}
