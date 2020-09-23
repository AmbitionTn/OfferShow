package 动态规划;

import org.omg.CORBA.DATA_CONVERSION;

/**
 * 122 买卖股票的最佳时机 II
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @create 2020/9/16
 */
public class _122_买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int dp[][] = new int[days][2];
        if (days < 1) {
            return 0;
        }
        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[days - 1][0], dp[days - 1][1]);
    }
}
