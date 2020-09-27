package 剑指Offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @create 2020/9/25
 */
public class _剑指Offer42连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
