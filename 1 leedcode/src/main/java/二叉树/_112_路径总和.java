package 二叉树;

/**
 * 112 路径总和
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/path-sum/
 * @create 2020/08/31
 */
public class _112_路径总和 {
    /**
     * 首先先对于一个节点来看，如果
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null){
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

class TreeNode112 {
    int val;
    TreeNode112 left;
    TreeNode112 right;
    TreeNode112(int x) { val = x; }
 }
