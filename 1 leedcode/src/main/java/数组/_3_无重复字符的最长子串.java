package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3_无重复字符的最长子串【中等】
 *
 * @author tning
 * Wcreate 2020/08/28
 * @URL：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_无重复字符的最长子串 {
    /**
     * 解析：使用set存储当前滑动窗口中的字符串，用于判断是否重复
     * 如果重复则不断将左侧滑动窗口右移并删除
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, result = 0, left_index = 0;
        // 用来判断字符是否重复
        Set<Character> set = new HashSet<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                result++;
                maxLength = Math.max(maxLength, result);
                set.add(s.charAt(i));
                continue;
            }
            while (set.contains(c)) {
                result--;
                set.remove(s.charAt(left_index++));
            }
            result++;
            set.add(c);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
