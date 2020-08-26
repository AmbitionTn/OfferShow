package 链表;

/**
 * 203 移除链表元素
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @create 2020/08/26
 */
class ListNode_203 {
    int val;
    ListNode_203 next;

    ListNode_203(int x) {
        val = x;
    }
}

public class _203_移除链表元素 {
    /**
     * 遍历链表找到并将上一个节点的next指向当前节点的下一个节点；主要连续重复元素情况
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode_203 removeElements(ListNode_203 head, int val) {
        ListNode_203 sentinel = new ListNode_203(0);
        sentinel.next = head;
        ListNode_203 pre = sentinel;
        ListNode_203 curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
