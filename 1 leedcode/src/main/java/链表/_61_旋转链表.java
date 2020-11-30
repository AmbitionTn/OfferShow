package 链表;

/**
 * @author taoning
 * @create 2020/11/3
 */
public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tailNode = head, pre = null;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }

        // 将链表链接起来
        tailNode.next = head;
        pre = tailNode;
        for (int i = 0; i < k; i++) {
            pre = head;
            head = head.next;
        }
        // 断开链表
        pre.next = null;
        return head;
    }
}
