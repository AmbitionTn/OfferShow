package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/3sum/
 * @create 2020/9/27
 */
public class _15三数之和 {
    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> res = twoSum(nums, i + 1, 0 - nums[i]);
            for (List<Integer> tmp : res) {
                tmp.add(nums[i]);
                ans.add(tmp);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param low
     * @param target
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int low, int target) {
        int hight = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < hight) {
            int sum = nums[low] + nums[hight];
            int left = nums[low], right = nums[hight];
            if (sum < target) {
                while (low < hight && nums[low] == left) low++;
            } else if (sum > target) {
                while (hight > low && nums[hight] == right) hight--;
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(left);
                tmp.add(right);
                res.add(tmp);
                while (low < hight && nums[low] == left) low++;
                while (hight > low && nums[hight] == right) hight--;
            }
        }
        return res;
    }
}
