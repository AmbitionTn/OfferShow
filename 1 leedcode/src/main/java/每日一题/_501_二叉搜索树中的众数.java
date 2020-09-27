package 每日一题;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @create 2020/9/24
 */
public class _501_二叉搜索树中的众数 {
    int base, count, maxCount;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode501 root) {
        TreeNode501 cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }

            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            base = x;
            count = 1;
        }
        if (count == maxCount) {
            ans.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }
}

class TreeNode501 {
    int val;
    TreeNode501 left;
    TreeNode501 right;

    TreeNode501(int x) {
        val = x;
    }
}

