package 链表;

/**
 * 141 环形链表
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/linked-list-cycle/
 * @create 2020/08/26
 */
public class _141_环形链表 {
    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode_141 head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode_141 quick = head.next;
        ListNode_141 slow = head;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}

class ListNode_141 {
    int val;
    ListNode_141 next;

    ListNode_141(int x) {
        val = x;
        next = null;
    }
}

