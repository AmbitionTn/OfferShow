package 二叉树;

/**
 * 100 相同的树
 * @URL:https://leetcode-cn.com/problems/same-tree/
 * @author taoning
 * @create 2020/9/14
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode100 {
    int val;
    TreeNode100 left;
    TreeNode100 right;
    TreeNode100() {}
    TreeNode100(int val) { this.val = val; }
    TreeNode100(int val, TreeNode100 left, TreeNode100 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
