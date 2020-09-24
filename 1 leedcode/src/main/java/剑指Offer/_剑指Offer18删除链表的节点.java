package 剑指Offer;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @create 2020/09/24
 */
public class _剑指Offer18删除链表的节点 {
    public ListNode18 deleteNode(ListNode18 head, int val) {
        ListNode18 dummy = new ListNode18(0);
        ListNode18 curr = head;
        dummy.next = head;
        ListNode18 pre = dummy;
        while (curr != null) {
            if (curr.val == val){
                dummy.next = curr.next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}

class ListNode18 {
    int val;
    ListNode18 next;

    ListNode18(int x) {
        val = x;
    }
}