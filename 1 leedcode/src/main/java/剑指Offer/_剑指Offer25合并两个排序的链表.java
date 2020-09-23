package 剑指Offer;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer25合并两个排序的链表 {
    public ListNode25 mergeTwoLists(ListNode25 l1, ListNode25 l2) {
        ListNode25 head = new ListNode25(0);
        ListNode25 tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = new ListNode25(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode25(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        while (l1 != null) {
            tmp.next = new ListNode25(l1.val);
            l1 = l1.next;
            tmp = tmp.next;
        }
        while (l2 != null) {
            tmp.next = new ListNode25(l2.val);
            l2 = l2.next;
            tmp = tmp.next;
        }
        return head.next;
    }
}

class ListNode25 {
    int val;
    ListNode25 next;

    ListNode25(int x) {
        val = x;
    }
}
