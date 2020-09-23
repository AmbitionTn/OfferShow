package 剑指Offer;

/**
 * 剑指Offer68二叉树的最近公共祖先
 * @URL：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author taoning
 * @create 2020/9/14
 */
public class _剑指Offer68二叉树的最近公共祖先 {
    public TreeNode68 lowestCommonAncestor(TreeNode68 root, TreeNode68 p, TreeNode68 q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode68 left = lowestCommonAncestor(root.left, p, q);
        TreeNode68 right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

class TreeNode68 {
    int val;
    TreeNode68 left;
    TreeNode68 right;

    TreeNode68(int x) {
        val = x;
    }
}

