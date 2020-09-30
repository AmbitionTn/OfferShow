package 二叉树;

/**
 * 563. 二叉树的坡度
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/binary-tree-tilt/
 * @create 2020/9/29
 */
public class _563二叉树的坡度 {
    private int res = 0;

    public int findTilt(TreeNode563 root) {
        dfs(root);
        return res;
    }

    /**
     * 直接使用DFS求解每一个子树的和，然后做ABS取绝对值就可以了
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode563 root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        ans += root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs((left - right));
        ans += left;
        ans += right;
        return ans;
    }
}

class TreeNode563 {
    int val;
    TreeNode563 left;
    TreeNode563 right;

    TreeNode563(int x) {
        val = x;
    }
}
