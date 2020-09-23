package 二叉树;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer32_1从上到下打印二叉树 {
    /**
     * 直接使用bfs广度优先搜索，在二叉树中就是层次遍历
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode32 root) {
        if (root == null) {
            return new int[0];
        }
        return dfs(root);
    }

    /**
     * 层次遍历二叉树
     *
     * @return
     */
    public int[] dfs(TreeNode32 root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode32> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode32 tmp = queue.poll();
            ans.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        int res[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}

class TreeNode32 {
    int val;
    TreeNode32 left;
    TreeNode32 right;

    TreeNode32(int x) {
        val = x;
    }
}