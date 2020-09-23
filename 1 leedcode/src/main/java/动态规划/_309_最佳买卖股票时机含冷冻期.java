package 动态规划;

/**
 * @author taoning
 * @create 2020/9/16
 */
public class _309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        // dp[i][0]代表第i天不持有股票的最大收益
        // dp[i][1]代表第i天持有股票的最大收益
        // dp[i][2]代码第i天处于冷冻期的最大收益
        int dp[][] = new int[days][3];
        int maxResult = 0;
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 0; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0];
        }
        return Math.max(dp[days - 1][0], dp[days - 1][1]);
    }
}
