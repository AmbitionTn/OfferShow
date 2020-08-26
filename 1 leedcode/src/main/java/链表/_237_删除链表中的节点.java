package 链表;

/**
 * 237 删除链表中的节点
 *
 * @author tning
 * @URL： https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @create 2020/08/26
 */
class ListNode_237 {
    int val;
    ListNode_237 next;
    ListNode_237(int x) { val = x; }
}
public class _237_删除链表中的节点 {
    /**
     * 当前节点指向下一节点
     * @param node
     */
    public void deleteNode(ListNode_237 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
