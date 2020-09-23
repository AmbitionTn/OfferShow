package 剑指Offer;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer22链表中倒数第k个节点 {
    public ListNode22 getKthFromEnd(ListNode22 head, int k) {
        ListNode22 low = head;
        ListNode22 fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}

class ListNode22 {
    int val;
    ListNode22 next;

    ListNode22(int x) {
        val = x;
    }
}
