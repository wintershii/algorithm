package dp;

/**
 * 题目:买卖股票的最佳时机
 * 来源:leetcode字节跳动专栏
 */
public class BugAndSellStock {
    public static void main(String[] args) {
        System.out.println(new BugAndSellStock().violence(new int[]{7,1,5,3,6,4}));
    }

    /**
     * 一次遍历法:找出最低谷和其之后的最高峰
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 暴力法 计算出所有可能的情况
     * 时间复杂度:O(n^2)
     */
    public int violence(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
