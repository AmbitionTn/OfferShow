package 二叉树;

import java.util.*;

/**
 * 257 二叉树的所有路径
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/binary-tree-paths/
 * @create 2020/09/01
 */
public class _257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode257 root) {
        List<String> result = new ArrayList<String>();
        dfs(root, result, "");
        return result;
    }

    /**
     * 使用递归遍历：
     * 解析：如果当前节点是叶子节点，则将路径加入到答案列表中
     * 如果当前节点不是叶子节点则将该节点加入路径末尾
     *
     * @param root
     * @param result
     * @param path
     */
    public void dfs(TreeNode257 root, List<String> result, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                result.add(path);
            } else {
                path += "->";
                dfs(root.left, result, path);
                dfs(root.right, result, path);
            }
        }
    }
}

class TreeNode257 {
    int val;
    TreeNode257 left;
    TreeNode257 right;

    TreeNode257(int x) {
        val = x;
    }
}

