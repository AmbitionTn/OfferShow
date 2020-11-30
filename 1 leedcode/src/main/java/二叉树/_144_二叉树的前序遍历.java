package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoning
 * @create 2020/10/27
 */
public class _144_二叉树的前序遍历 {
    private List<Integer> res = new ArrayList<>();

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return res;
        }
        res.add(root.val);
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }
        return res;
    }
}
