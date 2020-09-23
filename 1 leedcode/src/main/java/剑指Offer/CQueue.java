package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @create 2020/9/23
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * 初始化队列
     */
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) return stack2.pop();
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
