package 搜索;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taoning
 * @create 2020/11/5
 */
public class _127_单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean used[] = new boolean[wordList.size()];
        int ans  = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (tmp.equals(endWord)){
                return ans;
            }
            ans ++;
            int cnt = 0;
            for (String word : wordList) {
                for (int i = 0; i < tmp.length(); i++) {
                    if (word.charAt(i) != tmp.charAt(i)) {
                        cnt++;
                    }
                    if (cnt > 1) {
                        break;
                    }
                }
                if (!word.equals(tmp) && cnt <= 1) {
                    queue.add(word);
                }
            }
        }
        return 0;
    }
}
