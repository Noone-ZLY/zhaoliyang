import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Integer> main(String[] args) {
        public List<Integer> lexicalOrder(int n) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = i + 1;
            }
            Arrays.sort(nums, (a, b) -> (String.valueOf(a).compareTo(String.valueOf(b))));
            return Arrays.asList();
        }
    }
}
