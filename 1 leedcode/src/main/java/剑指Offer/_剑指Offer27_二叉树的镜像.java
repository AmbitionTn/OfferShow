package 二叉树;

/**
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/ 剑指 Offer 27. 二叉树的镜像
 * @create 2020/9/23
 */
public class _剑指Offer27_二叉树的镜像 {
    public TreeNode27 mirrorTree(TreeNode27 root) {
        if (root == null) {
            return null;
        }
        TreeNode27 left = mirrorTree(root.right);
        TreeNode27 right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}

class TreeNode27 {
    int val;
    TreeNode27 left;
    TreeNode27 right;

    TreeNode27(int x) {
        val = x;
    }
}
