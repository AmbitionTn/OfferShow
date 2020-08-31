package 字符串;

/**
 * 5 最长回文子串
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @create 2020/08/31
 */
public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendCenter(i, i, s);
            int len2 = expendCenter(i, i + 1, s);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 选定中心向两边扩展
     *
     * @param left
     * @param right
     * @param s
     * @return
     */
    public int expendCenter(int left, int right, String s) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
