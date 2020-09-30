package 链表;

/**
 * 876. 链表的中间结点
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @create 2020/9/30
 */
public class _876链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
