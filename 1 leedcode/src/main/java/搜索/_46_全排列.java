package 搜索;

import java.util.*;

/**
 * 46 全排列
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/permutations/
 * @create 2020/09/03
 */
public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, 0, path, len, res, used);
        return res;
    }

    /**
     * 使用递归 + 回溯遍历
     *
     * @param nums
     * @param depth
     * @param path
     * @param len
     * @param res
     */
    private void dfs(int[] nums, int depth, Deque<Integer> path, int len, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, depth + 1, path, len, res, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
