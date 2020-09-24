package 剑指Offer;

/**
 * 剑指 Offer 24. 反转链表
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @create 2020/09/24
 */
public class _剑指Offer24反转链表 {
    public ListNode24 reverseList(ListNode24 head) {
        ListNode24 curr = null, pre = head;
        while (pre.next != null) {
            ListNode24 tmp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = tmp;
        }
        return curr;
    }
}

class ListNode24 {
    int val;
    ListNode24 next;

    ListNode24(int x) {
        val = x;
    }
}
