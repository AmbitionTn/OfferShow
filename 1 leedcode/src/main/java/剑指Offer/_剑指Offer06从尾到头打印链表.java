package 剑指Offer;

import java.util.Stack;

/**
 * @author taoning
 * @create 2020/9/23
 */
public class _剑指Offer06从尾到头打印链表 {
    public int[] reversePrint(ListNode06 head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int ans[] = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index ++] = stack.pop();
        }
        return ans;
    }
}

class ListNode06 {
    int val;
    ListNode06 next;

    ListNode06(int x) {
        val = x;
    }
}
