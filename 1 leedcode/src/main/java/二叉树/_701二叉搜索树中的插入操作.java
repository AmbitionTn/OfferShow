package 二叉树;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @create 2020/9/30
 */
public class _701二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}

class TreeNode701 {
    int val;
    TreeNode701 left;
    TreeNode701 right;

    TreeNode701() {
    }

    TreeNode701(int val) {
        this.val = val;
    }

    TreeNode701(int val, TreeNode701 left, TreeNode701 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

