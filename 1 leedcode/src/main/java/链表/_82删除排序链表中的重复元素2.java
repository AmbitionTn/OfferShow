package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 82 删除排序链表中的重复元素 II
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @create 2020/9/13
 */
public class _82删除排序链表中的重复元素2 {
    public static ListNode82 deleteDuplicates(ListNode82 head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode82 dummy = new ListNode82(-1);
        dummy.next = head;
        ListNode82 a = dummy;
        ListNode82 b = head;

        while (b != null && b.next != null){
            if (a.next.val != b.next.val){
                a = a.next;
                b = b.next;
            }else {
                while (b != null && b.next != null && a.next.val != b.next.val){
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }
}

class ListNode82 {
    int val;
    ListNode82 next;

    ListNode82(int x) {
        val = x;
    }
}

