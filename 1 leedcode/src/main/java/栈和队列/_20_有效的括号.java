package 栈和队列;

import java.util.Stack;

/**
 * 20 有效的括号
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/valid-parentheses/
 * @create 2020/09/01
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        /**
         * 左括号入栈，右括号出栈并判断是否符合要求
         */
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char tmp = stack.pop();
                    if ((tmp == '[' && c != ']') || (tmp == '{' && c != '}') || (tmp == '(' && c != ')')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
