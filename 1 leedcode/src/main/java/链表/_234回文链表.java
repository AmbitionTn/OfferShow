package 链表;

/**
 * 234. 回文链表
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/palindrome-linked-list/
 * @create 2020/9/27
 */
public class _234回文链表 {
    private ListNode234 frontPointer;

    public boolean isPalindrome(ListNode234 head) {
        frontPointer = head;
        return travel(head);
    }

    /**
     * 递归遍历链表
     *
     * @param currentNode
     * @return
     */
    private boolean travel(ListNode234 currentNode) {
        if (currentNode != null) {
            if (!travel(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}

class ListNode234 {
    int val;
    ListNode234 next;

    ListNode234(int x) {
        val = x;
    }
}
