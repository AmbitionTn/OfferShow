package 二叉树;

/**
 * 404 左叶子之和
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @create 2020/9/19
 */
public class _404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode404 root) {
        return root == null ? 0 : dfs(root);
    }

    /**
     * 深度优先搜索
     *
     * @param node
     * @return
     */
    public int dfs(TreeNode404 node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    /**
     * 判断一个节点是不是叶子节点
     *
     * @param node
     * @return
     */
    public boolean isLeafNode(TreeNode404 node) {
        return (node.left == null && node.right == null) ? true : false;
    }

}

class TreeNode404 {
    int val;
    TreeNode404 left;
    TreeNode404 right;

    TreeNode404(int x) {
        val = x;
    }
}
