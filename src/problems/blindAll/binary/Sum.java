package problems.blindAll.binary;

public class Sum {

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b; // XOR
            b = temp;
        }
        return a;
    }
}
