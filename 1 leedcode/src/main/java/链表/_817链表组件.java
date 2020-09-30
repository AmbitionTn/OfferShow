package 链表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 817. 链表组件
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/linked-list-components/
 * @create 2020/9/30
 */
public class _817链表组件 {
    /**
     * 这里使用双指针，使用end每次从start开始，最后end == start证明不匹配，无需计算，如果最后的end和start不想等则证明匹配，直接加一。
     * 如果不相等需要给start + 1
     *
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }

        ListNode start = head, end;
        while (start != null) {
            end = start;
            boolean flag = true;
            while (end != null) {
                if (!set.contains(end.val)) {
                    break;
                }
                end = end.next;
            }
            if (start != end) {
                ans++;
                start = end;
                continue;
            }
            start = start.next;
        }
        return ans;
    }
}
