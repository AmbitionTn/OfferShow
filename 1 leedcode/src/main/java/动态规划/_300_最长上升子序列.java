package 动态规划;

import java.util.Arrays;

/**
 * 300 最长上升子序列
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @create 2020/9/13
 */
public class _300_最长上升子序列 {
    /**
     * 使用动态规划算饭，n方的复杂度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
