package 剑指Offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer21调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) != 0) {
                left++;
                continue;
            }
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    /**
     * 交换函数
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
