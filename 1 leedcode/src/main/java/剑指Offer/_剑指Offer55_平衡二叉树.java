package 二叉树;

/**
 * @author taoning
 * @create 2020/9/13
 */
public class _剑指Offer55_平衡二叉树 {
    public boolean isBalanced(TreeNode55 root) {
        if (root == null) {
            return true;
        }

        int leftDeep = deap(root.left);
        int rightDeap = deap(root.right);
        if (Math.abs(leftDeep - rightDeap) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
    public int deap(TreeNode55 root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deap(root.right), deap(root.left)) + 1;
    }
}

class TreeNode55 {
    int val;
    TreeNode55 left;
    TreeNode55 right;

    TreeNode55(int x) {
        val = x;
    }
}
