package 栈和队列;

import java.util.Arrays;

/**
 * 279 完全平方数
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/perfect-squares/
 * @create 2020/09/01
 */
public class _279_完全平方数 {
    /**
     * 使用dp[i] 表示数值为i时的解
     * 解析：由题目可以看出dp[i]的取值为当前值dp[i] 和 dp[i - squares[s]]+1 的最小值
     * 状态转移方程：dp[i] = Math.min(dp[i], dp[i - squares[s]] + 1);
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 使用DP数组存储之前的结果
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_queue_index = (int) (Math.sqrt(n) + 1);
        int squares[] = new int[max_queue_index];
        for (int i = 1; i < max_queue_index; i++) {
            squares[i] = i * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < max_queue_index; s++) {
                if (i < squares[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - squares[s]] + 1);
            }
        }
        return dp[n];
    }
}
