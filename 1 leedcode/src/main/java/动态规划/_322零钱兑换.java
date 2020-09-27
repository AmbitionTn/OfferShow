package 动态规划;

import java.util.List;
import java.util.Vector;

/**
 * 322. 零钱兑换
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/coin-change/
 * @create 2020/9/24
 */
public class _322零钱兑换 {
    /**
     * 使用dp[i]当金额为i时，需要的最少的硬币数量
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
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
