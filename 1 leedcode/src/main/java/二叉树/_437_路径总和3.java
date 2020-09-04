package 二叉树;

/**
 * 437 路径总和 III
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/path-sum-iii/
 * @create 2020/09/03
 */
public class _437_路径总和3 {
    public int pathSum(TreeNode437 root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * 对每一个节点进行DFS搜索
     *
     * @param root
     * @param sum
     * @return
     */
    private int dfs(TreeNode437 root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int tmp = 0;
        if (sum == 0) {
            tmp++;
        }
        return tmp + dfs(root.left, sum) + dfs(root.right, sum);
    }
}

class TreeNode437 {
    int val;
    TreeNode437 left;
    TreeNode437 right;

    TreeNode437() {
    }

    TreeNode437(int val) {
        this.val = val;
    }

    TreeNode437(int val, TreeNode437 left, TreeNode437 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}