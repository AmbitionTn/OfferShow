package 每日一题;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @create 2020/9/27
 */
public class _235二叉搜索树的最近公共祖先 {
    /**
     * 在二叉搜索树中，无需遍历所有的值；
     * 找最近公共祖先的题目：注意终止条件：root  == null 或 root == q 或 root = p
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode235 lowestCommonAncestor(TreeNode235 root, TreeNode235 p, TreeNode235 q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

class TreeNode235 {
    int val;
    TreeNode235 left;
    TreeNode235 right;

    TreeNode235(int x) {
        val = x;
    }
}
