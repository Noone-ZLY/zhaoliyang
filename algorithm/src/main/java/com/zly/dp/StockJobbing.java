package com.zly.dp;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/15 14:47
 */
public class StockJobbing {
    /**
     * @param [prices]
     * @return int
     * @description 121. 买卖股票的最佳时机
     * @author zhaoliyang
     * @create 2023/10/15 14:48
     */
    public static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for(int i = 0; i < prices.length; i++){
            min = prices[i] < min ? prices[i] : min;
            profit = prices[i] - min > profit ? prices[i] - min : profit;
        }
        return profit;
    }
    /**
     * @param [prices]
     * @return int
     * @description 122. 买卖股票的最佳时机 II
     * @author zhaoliyang
     * @create 2023/10/15 14:57
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit += Math.max(prices[i]-prices[i-1], 0);
        }
        return profit;
    }

    public static void main(String[] args) {

    }
}
