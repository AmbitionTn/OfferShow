package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @create 2020/9/25
 */
public class _106从中序与后序遍历序列构造二叉树 {
    public static TreeNode106 buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildByInOrderAndPostOrder(inorder, 0, inorder.length - 1
                , postorder, 0, postorder.length - 1, map);
    }

    /**
     * 根据中序遍历和后续遍历构建一颗二叉树
     *
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postOrder
     * @param postStart
     * @param postEnd
     * @param map
     * @return
     */
    private static TreeNode106 buildByInOrderAndPostOrder(int[] inorder, int inStart, int inEnd,
                                                          int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart < 0 || inEnd < 0 || postStart < 0 || postEnd < 0 || inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode106 root = new TreeNode106(postOrder[postEnd]);
        int rootIndex = map.get(root.val);
        int rightTreeLen = inEnd - rootIndex;
        TreeNode106 left = buildByInOrderAndPostOrder(inorder, inStart, rootIndex - 1
                , postOrder, postStart, postEnd - rightTreeLen - 1, map);
        TreeNode106 right = buildByInOrderAndPostOrder(inorder, rootIndex + 1, inEnd
                , postOrder, postEnd - rightTreeLen, postEnd - 1, map);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int inorder[] = {9, 3, 15, 20, 7};
        int postOrder[] = {9, 15, 7, 20, 3};
        buildTree(inorder, postOrder);
    }
}

class TreeNode106 {
    int val;
    TreeNode106 left;
    TreeNode106 right;

    TreeNode106(int x) {
        val = x;
    }
}