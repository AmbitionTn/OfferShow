package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer07重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1
                , inorder, 0, inorder.length - 1, map);
    }

    /**
     * 使用递归：通过前序遍历和中序遍历建立二叉树
     *
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @param map
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inOrder
                , inStart, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inOrder
                , inRoot + 1, inEnd, map);
        return root;
    }
}
