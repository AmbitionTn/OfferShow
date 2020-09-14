package 搜索;

import java.util.*;

/**
 * @39 组合总和
 * @URL：https://leetcode-cn.com/problems/combinations/
 * @author taoning
 * @create 2020/9/11
 */
public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, candidates.length, target, path, res);
        return res;
    }

    /**
     * 搜索：dfs
     * <p>
     * 创建一棵树：树上的每一个节点表示当前的目标值，如果不要求顺序使用begin，要求顺序使用used数组
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            // 如果当前的值已经小于0，那么比他更大的值一定也小于0
            if (target < 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            //状态重置
            path.removeLast();
        }
    }
}
