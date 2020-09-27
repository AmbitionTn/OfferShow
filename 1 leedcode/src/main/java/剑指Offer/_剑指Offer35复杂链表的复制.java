package 剑指Offer;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @create 2020/9/25
 */
public class _剑指Offer35复杂链表的复制 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}