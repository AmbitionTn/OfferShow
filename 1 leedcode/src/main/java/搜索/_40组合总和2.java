package 搜索;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 40 组合总和 II
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/combination-sum-ii/
 * @create 2020/09/10
 */
public class _40组合总和2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, candidates.length, target, 0, path, res);
        return res;
    }

    /**
     * DFS遍历，无重复
     *
     * @param candidates
     * @param len
     * @param target
     * @param begin
     * @param path
     * @param res
     */
    private void dfs(int[] candidates, int len, int target, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, target - candidates[i], i + 1, path, res);
            path.removeLast();
        }
    }
}
