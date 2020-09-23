package 剑指Offer;

/**
 * @author taoning
 * @create 2020/9/12
 */
public class _剑指_Offer10_2_青蛙跳台阶问题 {

    /**
     * 动态规划【超级简单】
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int dp[] = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
