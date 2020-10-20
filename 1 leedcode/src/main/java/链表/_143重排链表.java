package 链表;

import java.util.Stack;

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
        Stack<ListNode> stack = new Stack();
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
            len++;
        }
        ListNode p = head;
        for (int i = 0; i < len/2; i++) {
            ListNode q = stack.pop();
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        if (p != null){
            p.next = null;
        }
    }
}
