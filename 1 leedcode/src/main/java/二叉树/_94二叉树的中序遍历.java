package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 94 二叉树的中序遍历
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @create 2020/9/14
 */
public class _94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode94 root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        centerOrder(root, res);
        return res;
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root
     * @param res
     */
    public void centerOrder(TreeNode94 root, List<Integer> res) {
        if (root == null) {
            return;
        }
        centerOrder(root.left, res);
        res.add(root.val);
        centerOrder(root.right, res);
    }
}

class TreeNode94 {
    int val;
    TreeNode94 left;
    TreeNode94 right;

    TreeNode94(int x) {
        val = x;
    }
}

