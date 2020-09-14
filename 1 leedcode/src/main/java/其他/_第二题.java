package 其他;

import java.util.Scanner;

/**
 * @author tning
 * @create 2020/09/09
 * 最长的水沟
 */
public class _第二题 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        input();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(map, visit, i, j, -1));
            }
        }
        System.out.println(max - 1);
    }

    /**
     * 使用DFS遍历
     *
     * @param map
     * @param visit
     * @param i
     * @param j
     * @return
     */
    private static int dfs(int map[][], boolean visit[][], int i, int j, int current) {
        int max = 0;
        if (checkBoader(i, j) && !visit[i][j] && map[i][j] != current) {
            visit[i][j] = true;
            max = Math.max(max, dfs(map, visit, i + 1, j, map[i][j]));
            max = Math.max(max, dfs(map, visit, i - 1, j, map[i][j]));
            max = Math.max(max, dfs(map, visit, i, j + 1, map[i][j]));
            max = Math.max(max, dfs(map, visit, i, j - 1, map[i][j]));
            max += 1;
        }
        return max;
    }

    /**
     * 检测是否越界
     * @param i
     * @param j
     * @return
     */
    private static boolean checkBoader(int i, int j) {
        if (i >= 0 && j >= 0 && i < n && j < m) {
            return true;
        }
        return false;
    }

    /**
     * 输入函数
     */
    private static void input() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
    }
}
