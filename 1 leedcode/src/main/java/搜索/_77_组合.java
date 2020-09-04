package 搜索;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77 组合
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/combinations/
 * @create 2020/09/03
 */
public class _77_组合 {
    /**
     * 递归回溯 + 剪枝
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, path, 1, res, k);
        return res;
    }

    private void dfs(int n, Deque<Integer> path, int index, List<List<Integer>> res, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            dfs(n, path, i + 1, res, k);
            path.pop();
        }
    }
}
