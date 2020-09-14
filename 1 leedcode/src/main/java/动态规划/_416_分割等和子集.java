package 动态规划;

/**
 * 416 分割等和子集
 * @URL:https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @author taoning
 * @create 2020/9/12
 */
public class _416_分割等和子集 {
    /**
     * 01 背包的变形题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum / 2) * 2 == sum) {
            sum /= 2;
        } else {
            return false;
        }
        int dp[] = new int[sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i])
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum] == sum;
    }
}
