package 二叉树;

class TreeNode111 {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode111(int x) { val = x; }
}

/**
 * @author tning
 * @create 2020/08/21
 */
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
