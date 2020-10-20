package 每日一题;

import java.util.Stack;

/**
 * @author taoning
 * @create 2020/10/19
 */
public class _844_比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            } else if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stack2.push(T.charAt(i));
            } else if (!stack1.isEmpty()) {
                stack2.pop();
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        if (!stack1.isEmpty() || !stack2.isEmpty()) {
            return false;
        }
        return true;
    }
}
