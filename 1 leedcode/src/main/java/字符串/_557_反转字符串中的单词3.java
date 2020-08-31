package 字符串;

/**
 * 557 反转字符串中的单词 III
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @create 2020/08/30
 */
public class _557_反转字符串中的单词3 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String arr[] = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            builder.append(reverse(arr[i]));
            if (i != arr.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * 反转字符串
     *
     * @param s
     * @return
     */
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
