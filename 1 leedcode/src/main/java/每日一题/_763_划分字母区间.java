package 每日一题;

import java.util.List;

/**
 * @author taoning
 * @create 2020/10/22
 */
public class _763_划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        int start[] = new int[26];
        int end[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            if (start[(S.charAt(i) - 'a')] == 0) {
                start[(S.charAt(i) - 'a')] = i;
            } else {
                end[(S.charAt(i) - 'a')] = i;
            }
        }
        return null;
    }
}
