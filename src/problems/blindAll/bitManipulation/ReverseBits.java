package problems.blindAll.bitManipulation;

public class ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1; // left shifting to move elements to the top
            ans = ans | (n & 1);
            n >>= 1; // get the ith bit
        }
        return ans;
    }
}
