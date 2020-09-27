package 数组;

import java.util.*;

/**
 * 18. 四数之和
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/4sum/
 * @create 2020/9/27
 */
public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> res = threeSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tmp : res) {
                tmp.add(nums[i]);
                ans.add(tmp);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> res = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tmp : res) {
                tmp.add(nums[i]);
                ans.add(tmp);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }

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
