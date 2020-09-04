package 栈和队列;

import java.util.ArrayList;
import java.util.List;

/**
 * 144 二叉树的前序遍历
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @create 2020/09/01
 */
public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode144 root) {
        List<Integer> ans = new ArrayList<Integer>();
        preTraver(root, ans);
        return ans;
    }

    /**
     * 前序递归遍历方法
     *
     * @param root
     */
    public void preTraver(TreeNode144 root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preTraver(root.left, ans);
        preTraver(root.right, ans);
    }
}

class TreeNode144 {
    int val;
    TreeNode144 left;
    TreeNode144 right;

    TreeNode144(int x) {
        val = x;
    }
}
