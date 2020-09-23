package 二叉树;

/**
 * 538 把二叉搜索树转换为累加树
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @create 2020/9/23
 */
public class _538_把二叉搜索树转换为累加树 {
    int sum = 0;

    /**
     * 注意判断跟结点是否为空
     * 使用统一的sum记录所有的值
     *
     * @param root
     * @return
     */
    public TreeNode538 convertBST(TreeNode538 root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}

class TreeNode538 {
    int val;
    TreeNode538 left;
    TreeNode538 right;

    TreeNode538(int x) {
        val = x;
    }
}
