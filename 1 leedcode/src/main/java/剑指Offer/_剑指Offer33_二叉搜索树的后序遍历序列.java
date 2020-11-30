package 剑指Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

/**
 * @author taoning
 * @create 2020/11/3
 */
public class _剑指Offer33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        int[] inOrder = new int[postorder.length];
        for (int i = 0; i < postorder.length; i++) {
            inOrder[i] = postorder[i];
        }
        Arrays.sort(inOrder);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return tryBuildTree(inOrder, 0, inOrder.length -1, postorder, 0, postorder.length - 1, map);
    }

    /**
     * 使用中序遍历和后续遍历构建一颗二叉树
     *
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @param postOrder
     * @param postStart
     * @param postEnd
     * @param map
     * @return
     */
    private boolean tryBuildTree(int inOrder[], int inStart, int inEnd, int postOrder[], int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd){
            return true;
        }
        // 获得跟节点
        int node = postOrder[inEnd];
        // 中序遍历的根节点下标
        int inRoot = map.get(node);
        if (inRoot < inStart || inRoot > inEnd){
            return false;
        }
        int rightNums = inEnd - inRoot;
        return tryBuildTree(inOrder, inStart, inRoot - 1, postOrder, postStart, postEnd - rightNums - 1, map) &&
        tryBuildTree(inOrder, inRoot + 1, inEnd, postOrder, postEnd - rightNums, postEnd - 1, map);
    }
}
