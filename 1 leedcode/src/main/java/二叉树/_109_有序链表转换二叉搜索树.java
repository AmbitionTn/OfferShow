package 二叉树;

/**
 * 109 有序链表转换二叉搜索树
 * @author tning
 * @create 2020/08/18
 *
 * @url: https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */

class ListNode109 {
     int val;
     ListNode109 next;
     ListNode109() {}
     ListNode109(int val) { this.val = val; }
     ListNode109(int val, ListNode109 next) { this.val = val; this.next = next; }
}

class TreeNode109 {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode109() {}
     TreeNode109(int val) { this.val = val; }
     TreeNode109(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class _109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode109 head) {

        return null;
    }
}
