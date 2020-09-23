package 剑指Offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer12矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean used[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, used, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * DFS深度优先搜索
     *
     * @param board
     * @param used
     * @param i
     * @param j
     */
    public boolean dfs(char[][] board, boolean used[][], int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || word.charAt(index) != board[i][j] || used[i][j]) {
            return false;
        }
        used[i][j] = true;
        boolean res = dfs(board, used, i + 1, j, word, index + 1)
                || dfs(board, used, i - 1, j, word, index + 1)
                || dfs(board, used, i, j + 1, word, index + 1)
                || dfs(board, used, i, j - 1, word, index + 1);
        used[i][j] = false;
        return res;
    }
}