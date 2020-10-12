package 二叉树;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author taoning
 * @create 2020/10/12
 * @URL:https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class _530_二叉搜索树的最小绝对差 {

    private int min = Integer.MAX_VALUE;

    /**
     * 获得一颗二叉搜索树差的最小值
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        return min;
    }

    private void getMinResult(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            int right_min = getMin(root.right);
            min = Math.min(Math.abs(right_min - root.val), min);
            getMinResult(root.right);
        }
        if (root.left != null) {
            int left_max = getMax(root.left);
            min = Math.min(min, Math.abs(root.val - left_max));
            getMinResult(root.left);
        }
    }

    /**
     * 获得一颗二叉树搜索树的最大值
     *
     * @param root
     */
    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 获得一颗二叉搜索树的最小值
     *
     * @param root
     */
    private int getMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
