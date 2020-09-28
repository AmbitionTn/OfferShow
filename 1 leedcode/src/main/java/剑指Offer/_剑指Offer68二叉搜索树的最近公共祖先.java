package 剑指Offer;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @create 2020/9/28
 */
public class _剑指Offer68二叉搜索树的最近公共祖先 {
    /**
     * 二叉树的最近公共祖先
     * <p>
     * 返回条件 为null或者已经到达p，q节点
     * <p>
     * 如果左侧为返回为null 则返回右侧
     * 如果右侧为null 则返回左侧
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null) return left;
        if (left == null) return right;
        return root;
    }
}
