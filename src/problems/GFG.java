package problems;

import java.util.Scanner;

public class GFG {

    public static void main (String[] args) {
        Scanner sc =  new Scanner(System.in);
        int testCases = sc.nextInt();
        int a, b;
        while (testCases --> 0) {


        }
        int[] intsA = new int[]{8, 4, 5, 6, 7};
        int[] intsB = new int[]{2, 3, 4, 5, 6, 7};
        System.out.println(gfg(intsA, intsB));
    }

    public static String gfg(int[] intsA, int[] intsB) {
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < intsA.length; i++) {
            c1 = Math.max(c1, intsA[i]);
        }

        for (int i = 0; i < intsB.length; i++) {
            c2 = Math.max(c2, intsB[i]);
        }

        if (c1 > c2) {
            return "C1";
        } else {
            return "C2";
        }
    }
}
