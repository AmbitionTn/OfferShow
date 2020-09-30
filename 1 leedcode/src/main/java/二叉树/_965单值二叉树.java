package 二叉树;

/**
 * 965. 单值二叉树
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/univalued-binary-tree/
 * @create 2020/9/29
 */
public class _965单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int rootVal = root.val;
        return dfs(root, rootVal);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left, val) && dfs(root.right, val);
    }
}

class TreeNode965 {
    int val;
    TreeNode965 left;
    TreeNode965 right;

    TreeNode965(int x) {
        val = x;
    }
}
