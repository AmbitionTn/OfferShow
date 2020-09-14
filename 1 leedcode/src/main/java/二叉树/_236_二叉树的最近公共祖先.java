package 二叉树;

import com.oracle.javafx.jmx.json.JSONReader;

/**
 * 236 二叉树的最近公共祖先
 * @URL:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author taoning
 * @create 2020/9/14
 */
public class _236_二叉树的最近公共祖先 {
    public TreeNode236 lowestCommonAncestor(TreeNode236 root, TreeNode236 p, TreeNode236 q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode236 left = lowestCommonAncestor(root.left, p, q);
        TreeNode236 right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

class TreeNode236 {
    int val;
    TreeNode236 left;
    TreeNode236 right;
    TreeNode236(int x) { val = x; }
}

