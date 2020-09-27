package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @create 2020/9/27
 */
public class _剑指Offer34二叉树中和为某一值的路径 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode34 root, int sum) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs(root, res, sum);
        return ans;
    }

    /**
     * 使用DFS搜索 + 回溯
     *
     * @param root
     * @param track
     * @param sum
     */
    private void dfs(TreeNode34 root, LinkedList<Integer> track, int sum) {
        if (root == null) {
            return;
        }
        track.add(root.val);
        sum -= root.val;
        // 终止条件:该节点为叶子节点，该节点值等于sum
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(track));
            return;
        }
        dfs(root.left, track, sum);
        dfs(root.right, track, sum);
        track.removeLast();

    }
}

class TreeNode34 {
    int val;
    TreeNode34 left;
    TreeNode34 right;

    TreeNode34(int x) {
        val = x;
    }
}
