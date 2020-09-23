package 二叉树;

/**
 * @author taoning
 * @create 2020/9/23
 */
public class _617_合并二叉树 {
    public TreeNode617 mergeTrees(TreeNode617 t1, TreeNode617 t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode617 merge = new TreeNode617(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }
}

/**
 * 二叉树节点Node
 */
class TreeNode617 {
    int val;
    TreeNode617 left;
    TreeNode617 right;

    TreeNode617(int x) {
        val = x;
    }
}

