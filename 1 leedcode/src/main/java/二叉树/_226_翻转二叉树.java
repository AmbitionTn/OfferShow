package 二叉树;

/**
 * 226 翻转二叉树
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/invert-binary-tree/
 * @create 2020/08/31
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}

class TreeNode226 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode226(int x) {
        val = x;
    }
}