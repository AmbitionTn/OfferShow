package 字符串;

/**
 * @author tning
 * @create 2020/08/24
 * <p>
 * 459 重复的子字符串
 */
public class _459_重复的子字符串 {
    /**
     * 解析：如果一个字符串由几个子串构成，那么这个字符串S可以被分成若干个S1
     * 将两个字符串拼接后就会由双倍的s1构成，那么找出第一个字符串与原字符串重复的位置一定不是原字符串后面。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
