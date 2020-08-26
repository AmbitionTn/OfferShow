package 链表;

import sun.awt.windows.ThemeReader;

import java.util.HashMap;

class ListNode_83 {
    int val;
    ListNode_83 next;

    ListNode_83(int x) {
        val = x;
    }
}

/**
 * 83 删除排序链表中的重复元素
 *
 * @author tning
 * @URL https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @create 2020/08/26
 */
public class _83_删除排序链表中的重复元素 {
    /**
     * 解析：通过判断当前节点与前一个节点的值是否相同，如果相同则删除。
     * 这里需要注意，如果第一个节点与哨兵节点一样需要保留
     *
     * @param head
     * @return
     */
    public ListNode_83 deleteDuplicates(ListNode_83 head) {
        if (head == null) {
            return head;
        }
        ListNode_83 sentinel = new ListNode_83(0);
        sentinel.next = head;
        ListNode_83 pre = sentinel, curr = head;
        while (curr != null) {
            if (pre.val == curr.val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head.val != 0 ? sentinel.next : sentinel;
    }
}
