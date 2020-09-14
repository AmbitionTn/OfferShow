package 动态规划;

/**
 * 70 爬楼梯
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/climbing-stairs/
 * @create 2020/9/11
 */
public class _70_爬楼梯 {
    /**
     * DP[i] = Dp[i - 1] + dp[i - 2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        if (n <= 2){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
