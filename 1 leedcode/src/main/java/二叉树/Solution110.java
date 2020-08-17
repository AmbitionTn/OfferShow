package 二叉树;


/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * @url： https://leetcode-cn.com/problems/balanced-binary-tree/
 */
class Solution110 {
    /**
     * 递归判断是否是左子树和右子树深度，是否相差1
     * 同时递归判断左子树和右子树是否是平衡树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(getTreeDeapth(root.left) - getTreeDeapth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 获取二叉树的深度
     *
     * @return
     */
    private int getTreeDeapth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeDeapth(root.right), getTreeDeapth(root.left)) + 1;
    }
}
