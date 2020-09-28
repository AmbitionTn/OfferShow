package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @create 2020/9/28
 */
public class _117填充每个节点的下一个右侧节点指针2 {
    /**
     * 直接使用BFS对每一层进行遍历，同时将这一层的节点next连接
     * 这里无需管理最后一个节点的next，应为如果最后一个没有写默认是null
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            Node last = null;
            for (int i = 0; i < count; i++) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.add(f.left);
                }
                if (f.right != null) {
                    queue.add(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
