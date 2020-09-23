package 剑指Offer;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer26树的子结构 {
    /**
     * 使用递归判断子树情况
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode261 A, TreeNode261 B) {
        return (A != null && B != null)
                && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode261 A, TreeNode261 B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

class TreeNode261 {
    int val;
    TreeNode261 left;
    TreeNode261 right;

    TreeNode261(int x) {
        val = x;
    }
}
