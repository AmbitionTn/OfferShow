package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tning
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @create 2020/9/12
 */
public class _637_二叉树的层平均值 {

    /**
     * 二叉树的层次遍历 （使用队列存储，并使用cnt记录每层节点个数）
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode637 root) {
        Queue<TreeNode637> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        bfs(root, queue, res);
        return res;
    }

    /**
     * 广度优先搜索
     * <p>
     * BFS
     */
    private void bfs(TreeNode637 root, Queue<TreeNode637> queue, List<Double> res) {
        queue.add(root);
        while (!queue.isEmpty()) {
            double num = 0;
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode637 tmp = queue.poll();
                num += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            res.add(num / cnt);
        }
    }
}

class TreeNode637 {
    int val;
    TreeNode637 left;
    TreeNode637 right;

    TreeNode637(int x) {
        val = x;
    }
}
