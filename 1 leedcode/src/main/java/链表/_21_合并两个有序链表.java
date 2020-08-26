package 链表;

/**
 * 21 合并两个有序链表【简单】
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @create 2020/08/26
 */
public class _21_合并两个有序链表 {
    /**
     * 使用两个指针遍历，合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode_21 mergeTwoLists(ListNode_21 l1, ListNode_21 l2) {
        ListNode_21 sentinel = new ListNode_21(0);
        ListNode_21 curr = sentinel;
        // 比较大小将小的数值放在新的链表中
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                curr.next = new ListNode_21(l1.val);
                l1 = l1.next;
            }else{
                curr.next = new ListNode_21(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 将剩余的l1都放在链表中
        while (l1 != null){
            curr.next = new ListNode_21(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null){
            curr.next = new ListNode_21(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }
        return sentinel.next;
    }
}

class ListNode_21 {
    int val;
    ListNode_21 next;
    ListNode_21() {}
    ListNode_21(int val) { this.val = val; }
    ListNode_21(int val, ListNode_21 next) { this.val = val; this.next = next; }
}


