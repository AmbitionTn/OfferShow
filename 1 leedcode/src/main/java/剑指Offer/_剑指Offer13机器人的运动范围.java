package 剑指Offer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer13机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        boolean used[][] = new boolean[m][n];
        int ans = 0;
        dfs(m, n, 0, 0, k, used);
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                if (used[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * dfs 遍历，同时更新used数组
     *
     * @param m
     * @param n
     * @param i
     * @param j
     * @param k
     * @param used
     */
    public void dfs(int m, int n, int i, int j, int k, boolean used[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || cal(i, j) > k) {
            return;
        }
        used[i][j] = true;
        dfs(m, n, i + 1, j, k, used);
        dfs(m, n, i - 1, j, k, used);
        dfs(m, n, i, j + 1, k, used);
        dfs(m, n, i, j - 1, k, used);
    }

    /**
     * 计算两个数的值
     *
     * @param a
     * @param b
     * @return
     */
    private int cal(int a, int b) {
        int sum = 0;
        if (a >= 10) {
            sum += a % 10;
            sum += a / 10;
        } else if (a < 10) {
            sum += a;
        }

        if (b >= 10) {
            sum += b % 10;
            sum += b / 10;
        } else if (b < 10) {
            sum += b;
        }
        return sum;
    }
}
