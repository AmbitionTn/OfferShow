package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taoning
 * @create 2020/10/14
 */
public class _1002查找常用字符 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int cnt[] = new int[26];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        for (String s : A) {
            // 对于每一个字符串记录各个字符出现的次数
            int tmp[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                tmp[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < tmp.length; i++) {
                cnt[i] = Math.min(tmp[i], cnt[i]);
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
