package 栈和队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102 二叉树的层序遍历
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @create 2020/09/01
 */
public class _102_二叉树的层序遍历 {
    /**
     * 使用队列进行层次遍历 这里需要注意因为要展示每一层，所以需要在一层中使用for循环出队元素。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode102 root) {
        Queue<TreeNode102> queue = new LinkedList<TreeNode102>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode102 node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(levelList);
        }
        queue.add(root);
        return ans;
    }
}

class TreeNode102 {
    int val;
    TreeNode102 left;
    TreeNode102 right;

    TreeNode102(int x) {
        val = x;
    }
}
