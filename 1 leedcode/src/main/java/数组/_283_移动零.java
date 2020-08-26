package 数组;

import java.util.Arrays;

/**
 * 283 移动零
 *
 * @author tning
 * @URL: https://leetcode-cn.com/problems/move-zeroes/
 * @create 2020/08/26
 */
public class _283_移动零 {
    /**
     * 解析：使用curr_index来标记当前下标，在遍历数组过程中不等于0的数放在curr_index位置，curr_index ++
     * 同时在最后遍历完后直接在末尾补0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int curr_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[curr_index++] = nums[i];
            }
        }
        for (int i = curr_index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
