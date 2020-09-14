package 二叉树;

/**
 * 235 二叉搜索树的最近公共祖先
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @create 2020/09/03
 */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode235 lowestCommonAncestor(TreeNode235 root, TreeNode235 p, TreeNode235 q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode235 left = lowestCommonAncestor(root.left, p, q);
        TreeNode235 right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

class TreeNode235 {
    int val;
    TreeNode235 left;
    TreeNode235 right;

    TreeNode235(int x) {
        val = x;
    }
}
