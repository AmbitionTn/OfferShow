package 搜索;

import java.util.*;

/**
 * @author taoning
 * @create 2020/11/2
 */
public class _字符串全排列 {
    private static List<List<Character>> res = new ArrayList<>();

    /**
     * 使用DFS完成数组的全排列
     *
     * @param s
     * @param depth
     */
    private static void dfs(String s, int depth, Deque<Character> path, int len, boolean used[]) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(s.charAt(i));
            dfs(s, depth + 1, path, len,  used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        Deque<Character> deque = new ArrayDeque<>();
        boolean used[] = new boolean[s.length()];
        dfs(s, 0, deque, s.length(),used);
        System.out.println(res);
    }
}
