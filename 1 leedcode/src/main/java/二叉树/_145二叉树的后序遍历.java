package 二叉树;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @create 2020/9/28
 */
public class _145二叉树的后序遍历 {

    private List<Integer> ans = new ArrayList<>();

    /**
     * 使用递归方式实现后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode145 root) {
        Stack<TreeNode145> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root != null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode145 tmp = stack.pop();
            ans.addFirst(tmp.val);
            if (tmp.left != null){
                stack.push(tmp.left);
            }
            if (tmp.right != null){
                stack.push(tmp.right);
            }
        }
        return ans;
    }
}

class TreeNode145 {
    int val;
    TreeNode145 left;
    TreeNode145 right;

    TreeNode145() {
    }

    TreeNode145(int val) {
        this.val = val;
    }

    TreeNode145(int val, TreeNode145 left, TreeNode145 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

