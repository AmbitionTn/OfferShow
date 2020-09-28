package 剑指Offer;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @create 2020/9/28
 */
public class _剑指Offer54二叉搜索树的第k大节点 {
    private int res, k;

    /**
     * 二叉搜索树的中序遍历是有序的：所以直接中序然后提前结束就可以了
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
