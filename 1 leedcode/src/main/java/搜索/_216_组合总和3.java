package 搜索;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216 组合总和3
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/combination-sum-iii/
 * @create 2020/9/11
 */
public class _216_组合总和3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(n, 1, k, 0, path, res);
        return res;
    }

    /**
     * DFS搜索并回溯
     *
     * @param target
     * @param k
     */
    private static void dfs(int target, int begin, int k, int step, Deque<Integer> path, List<List<Integer>> res) {
        // 不满足条件
        if (target < 0 || step > k) {
            return;
        }

        // 当前目标满足同时步数满足k
        if (target == 0 && step == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < 9; i++) {
            path.addLast(i);
            dfs(target - i, i + 1, k, step + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }
}
