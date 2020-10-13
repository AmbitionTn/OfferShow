package 链表;

/**
 * 82 两两交换链表中的节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @create 2020/9/13
 */
public class _24_两两交换链表中的节点 {
    /**
     * 引入哨兵节点：然后主要是注意梳理节点之间的引用关系，就可以直接AC
     * 在写代码是要注意边界的考虑，例如head为null或者head.next为null
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = new ListNode(0);
        ListNode newHead = head.next;
        preNode.next = head;

        while (preNode.next != null && preNode.next.next != null) {
            ListNode p1 = preNode.next;
            ListNode p2 = p1.next;
            p1.next = p2.next;
            p2.next = p1;
            preNode.next = p2;
            preNode = p1;
        }
        return newHead;
    }
}

class ListNode24 {
    int val;
    ListNode24 next;

    ListNode24(int x) {
        val = x;
    }
}
