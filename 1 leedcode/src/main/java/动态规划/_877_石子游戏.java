package 动态规划;

/**
 * @author taoning
 * @create 2020/10/30
 */
public class _877_石子游戏 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair dp[][] = new Pair[n][n];

        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        // 初始化dp[i][i] 使得对于每一个堆来说先手都回全部取走，所以dp[i][i] == piles[i]
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
        }

        for (int l = 1; l <= n - 1; l++) {
            for (int i = 0; i <= n - l - 1; i++) {
                int j = l + i;
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;
                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        return dp[0][n - 1].first > dp[0][n - 1].second;
    }

    class Pair {
        protected int first;
        protected int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
