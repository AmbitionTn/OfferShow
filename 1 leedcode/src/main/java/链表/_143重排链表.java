package 链表;

/**
 * 143. 重排链表
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/reorder-list/
 * @create 2020/9/30
 */
public class _143重排链表 {
    private ListNode pointNode;

    public void reorderList(ListNode head) {
        pointNode = head;
        change(head.next, pointNode);
    }

    /**
     * 使用递归栈：将数组一个个的替换
     *
     * @param curr
     */
    public void change(ListNode curr, ListNode pre) {
        if (pointNode.next == curr || pointNode.next.next == curr) {
            return;
        }

        if (curr.next != null) {
            change(curr.next, curr);
        }

        System.out.println(curr.val);
        ListNode tmp = pointNode;
        pre.next = curr.next;
        pointNode.next = curr;
        curr.next = tmp.next;
        pointNode = pointNode.next;
    }
}
