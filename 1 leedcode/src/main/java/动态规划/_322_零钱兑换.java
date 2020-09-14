package 动态规划;

/**
 * 322 零钱兑换
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/coin-change/
 * @create 2020/9/12
 */
public class _322_零钱兑换 {
    /**
     * 解析：使用动态规划求解
     * Dp[i] 表示总金额为i时的需要硬币数量的最小值
     * dp[i - coin]代表不算当前硬币的最优值，算上当前硬币只需要加1即可
     * 设立base = 0
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
