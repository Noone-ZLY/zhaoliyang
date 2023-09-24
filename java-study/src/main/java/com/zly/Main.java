import java.util.ArrayList;
import java.util.List;

public class Main{
    public static List<Integer> selectItems(int[] prices, int[] weights, int budget, int maxWeight) {
        int n = prices.length;
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w && prices[i - 1] + dp[i - 1][w - weights[i - 1]] > dp[i - 1][w])
                    dp[i][w] = prices[i - 1] + dp[i - 1][w - weights[i - 1]];
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        int res = dp[n][maxWeight];
        int w = maxWeight;
        List<Integer> selectedItems = new ArrayList<>();

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                selectedItems.add(i-1);
                res -= prices[i - 1];
                w -= weights[i - 1];
            }
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        int[] prices = {10, 20, 30, 20, 10};
        int[] weights = {1, 2, 3, 1, 4};
        int budget = 50;
        int maxWeight = 5;

        List<Integer> selectedItems = selectItems(prices, weights, budget, maxWeight);

        System.out.println("Selected items:");
        for (Integer num : selectedItems) {
            System.out.println("Index:" + num);
        }
    }
}
