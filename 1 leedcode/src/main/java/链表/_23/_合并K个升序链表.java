package 链表._23;

import java.nio.IntBuffer;
import java.util.*;

/**
 * @author taoning
 * @create 2020/11/9
 */
public class _合并K个升序链表 {
    public ListNode23 mergeKLists(ListNode23[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode23 merge(ListNode23[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTeoNum(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 合并两个链表
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode23 mergeTeoNum(ListNode23 a, ListNode23 b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode23 head = new ListNode23(0);
        while (a != null && b != null) {
            if (a.val < b.val) {
                head.next = new ListNode23(a.val);
                a = a.next;
            } else {
                head.next = new ListNode23(b.val);
                b = b.next;
            }
        }

        while (a != null) {
            head.next = new ListNode23(a.val);
            a = a.next;
        }

        while (b != null) {
            head.next = new ListNode23(b.val);
            b = b.next;
        }
        return head.next;
    }
}

class ListNode23 {
    int val;
    ListNode23 next;

    ListNode23() {
    }

    ListNode23(int val) {
        this.val = val;
    }

    ListNode23(int val, ListNode23 next) {
        this.val = val;
        this.next = next;
    }
}


