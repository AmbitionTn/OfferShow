package 动态规划;

/**
 * @author taoning
 * @create 2020/9/22
 */
public class _01背包问题 {
    /**
     * 二维数组01背包问题
     *
     * @param N
     * @param W
     * @param values
     * @param weight
     * @return
     */
    public int dp_01(int N, int W, int values[], int weight[]) {
        int dp[][] = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - weight[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 新01背包问题，解决将二维数组进行压缩存储
     *
     * @param N
     * @param W
     * @param values
     * @param weight
     * @return
     */
    public int dp_01_new(int N, int W, int values[], int weight[]) {
        int dp[] = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = weight[W - 1]; j >= 0; j--) {
                if (j >= weight[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[W];
    }
}
