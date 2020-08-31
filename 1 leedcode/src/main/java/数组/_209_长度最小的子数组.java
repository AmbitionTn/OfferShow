package 数组;

/**
 * 209 长度最小的子数组
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @create 2020/08/28
 */
public class _209_长度最小的子数组 {
    /**
     * 解析：使用滑动窗口，两个指针分别指向不同的位置，如果和比要求的大那么left++,缩短数组长度
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE, left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s && left <= i) {
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }

    public static void main(String[] args) {
        int s = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        int len = minSubArrayLen(s, nums);
        System.out.println(len);
    }
}
