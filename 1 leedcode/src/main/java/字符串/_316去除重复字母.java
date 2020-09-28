package 字符串;

import java.util.Stack;

/**
 * 316. 去除重复字母
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/remove-duplicate-letters/
 * @create 2020/9/28
 */
public class _316去除重复字母 {
    /**
     * 使用单调栈：同时使用一个计数数组，用来判断这个字符后面是否还有出现过，如果后面没有出现过就不该移除。
     * 这里使用了一个instack数组用来判断一个字符是否在栈中出现过
     * <p>
     * 同时为了保证按照顺序，所以在放入栈中一个新的字符的时候需要判断，这个栈最上面的字符是否比当前字符要小，如果字符串最上面的字符比当前
     * 字符小就应该出栈。
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // 标记是否出现在栈中
        boolean inStack[] = new boolean[256];
        // 记录每一种字符出现的次数
        int count[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

