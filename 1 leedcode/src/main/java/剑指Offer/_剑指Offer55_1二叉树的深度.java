package 剑指Offer;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer55_1二叉树的深度 {
    public int maxDepth(TreeNode55_1 root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class TreeNode55_1 {
    int val;
    TreeNode55_1 left;
    TreeNode55_1 right;

    TreeNode55_1(int x) {
        val = x;
    }
}
