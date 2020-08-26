package 链表;

class ListNode_206 {
    int val;
    ListNode_206 next;

    ListNode_206(int x) {
        val = x;
    }
}

/**
 * 206 反转链表
 *
 * @author tning
 * @url: https://leetcode-cn.com/problems/reverse-linked-list/
 * @create 2020/08/26
 */
public class _206_反转链表 {
    /**
     * 解析：每一次将当前节点下一个节点指向头部，当前链表的头部指向当前节点，然后遍历
     *
     * @param head
     * @return
     */
    public ListNode_206 reverseList(ListNode_206 head) {
        ListNode_206 pre = null;
        ListNode_206 curr = head;
        while (curr != null) {
            ListNode_206 nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }
        return pre;
    }
}
