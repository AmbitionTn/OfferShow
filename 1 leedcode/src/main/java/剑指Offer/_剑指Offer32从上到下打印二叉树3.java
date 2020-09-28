package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @create 2020/9/28
 */
public class _剑指Offer32从上到下打印二叉树3 {
    /**
     * 使用一个标记，用来表示放入顺序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        boolean isLeft = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isLeft = !isLeft;
            ans.add(tmp);
        }
        return ans;
    }
}

class TreeNode321 {
    int val;
    TreeNode321 left;
    TreeNode321 right;

    TreeNode321(int x) {
        val = x;
    }
}
