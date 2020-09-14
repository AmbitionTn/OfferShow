package 动态规划;

import java.util.Arrays;

/**
 * 53 最大子序和
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/maximum-subarray/
 * @create 2020/9/13
 */
public class _53_最大子序和 {
    /**
     * 简单DP
     * 很简单的最长连续上升子序列的和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
