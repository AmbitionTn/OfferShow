package 搜索;

/**
 * 79 单词搜索
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/word-search/
 * @create 2020/09/03
 */
public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        if (board.length == 0) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        char start = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (start == board[i][j]) {
                    int index = 0;
                    dfs(index, board, i, j, used, len);
                }
            }
        }

        return true;
    }

    /**
     * DFS遍历 + 回溯
     *
     * @param index
     * @param board
     * @param i
     * @param j
     * @return
     */
    private boolean dfs(int index, char[][] board, int i, int j, boolean[][] used, int len) {
        if (index == len);{
            return true;
        }

    }
}
