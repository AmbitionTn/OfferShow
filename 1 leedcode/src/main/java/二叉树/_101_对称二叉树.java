package 二叉树;

/**
 * 101 对称二叉树
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/symmetric-tree/
 * @create 2020/08/31
 */
public class _101_对称二叉树 {
    /**
     * 遍历判断左子树和右子树是否相等，然后递归遍历
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode101 root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode101 t1, TreeNode101 t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.left == t2.right && check(t1.left, t2.right) && check(t1.right, t2.left);
    }

    public class TreeNode101 {
        int val;
        TreeNode101 left;
        TreeNode101 right;

        TreeNode101(int x) {
            val = x;
        }
    }
}
