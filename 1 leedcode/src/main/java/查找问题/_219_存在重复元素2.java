package 查找问题;


import java.util.HashSet;
import java.util.Set;

/**
 * 219 存在重复元素 II
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @create 2020/08/28
 */
public class _219_存在重复元素2 {
    /**
     * 解析：题目中需要注意k值可能比数组长度大
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left_index = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[left_index++]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
