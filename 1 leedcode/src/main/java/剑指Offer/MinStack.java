package 剑指Offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @create 2020/9/25
 */
public class MinStack {
    private Stack<Integer> staA, staB;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        staA = new Stack<>();
        staB = new Stack<>();
    }

    public void push(int x) {
        staA.add(x);
        if (staB.isEmpty() || staB.peek() >= x) {
            staB.push(x);
        }
    }

    public void pop() {
        if (staA.pop().equals(staB.peek())) {
            staB.pop();
        }
    }

    public int top() {
        return staA.peek();
    }

    public int min() {
        return staB.peek();
    }
}
