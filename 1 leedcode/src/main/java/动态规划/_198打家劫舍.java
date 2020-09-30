package 动态规划;

/**
 * 198. 打家劫舍
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/house-robber/
 * @create 2020/9/30
 */
public class _198打家劫舍 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
