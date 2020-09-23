package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 78 子集
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/subsets/
 * @create 2020/9/23
 */
public class _78子集 {
    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 通过使用二进制位标记当前各个位
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mark = 0; mark < (1 << n); mark++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mark & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }
}
