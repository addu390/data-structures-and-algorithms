package problems.leetcode.array;

public class BuyAndSell {

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - min) > profit) {
                profit = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.print(maxProfit(new int[]{1, 0}));
    }
}
