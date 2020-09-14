package 链表;

/**
 * 82 两两交换链表中的节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @create 2020/9/13
 */
public class _24_两两交换链表中的节点 {
    public ListNode24 swapPairs(ListNode24 head) {
        ListNode24 dummy = new ListNode24(-1);
        dummy.next = head;

        ListNode24 preNode = dummy;
        while (head != null && head.next != null){

        }
        return dummy.next;
    }
}

class ListNode24 {
    int val;
    ListNode24 next;
    ListNode24(int x) { val = x; }
}
