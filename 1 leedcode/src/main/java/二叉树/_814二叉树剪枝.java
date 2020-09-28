package 二叉树;

/**
 * 814. 二叉树剪枝
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/binary-tree-pruning/
 * @create 2020/9/28
 */
public class _814二叉树剪枝 {
    /**
     * 直接使用递归就可以了：返回null 的条件
     * 1、当前节点
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}

class TreeNode814 {
    int val;
    TreeNode814 left;
    TreeNode814 right;

    TreeNode814() {
    }

    TreeNode814(int val) {
        this.val = val;
    }

    TreeNode814(int val, TreeNode814 left, TreeNode814 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


