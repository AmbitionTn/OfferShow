package 链表;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @create 2020/9/28
 */
public class _19删除链表的倒数第N个节点 {
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 dummy = new ListNode19(0);
        dummy.next = head;
        int length = 0;
        ListNode19 first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}

class ListNode19 {
    int val;
    ListNode19 next;

    ListNode19(int x) {
        val = x;
    }
}
