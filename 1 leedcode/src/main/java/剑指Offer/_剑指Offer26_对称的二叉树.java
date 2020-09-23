package 剑指Offer;

/**
 * @author taoning
 * @create 2020/9/13
 */
public class _剑指Offer26_对称的二叉树 {
    public boolean isSymmetric(TreeNode26 root) {
        return root == null ? true : dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode26 left, TreeNode26 right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}


class TreeNode26 {
    int val;
    TreeNode26 left;
    TreeNode26 right;

    TreeNode26(int x) {
        val = x;
    }
}
