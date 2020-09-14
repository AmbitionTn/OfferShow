package 搜索;

/**
 * 79 单词搜索
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/word-search/
 * @create 2020/09/03
 */
public class _79_单词搜索 {
    /**
     * 单词搜索
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean used[][] = new boolean[board.length][board[0].length];
                    if (dfs(i, j, 0, used, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * DFS搜索
     *
     * @param len
     * @param used
     * @param board
     */
    private static boolean dfs(int i, int j, int len, boolean used[][], char[][] board, String word) {
        if (len == word.length()) {
            return true;
        }

        if (checkBorder(i, j, board) && !used[i][j] && board[i][j] == word.charAt(len)) {
            char c = board[i][j];
            used[i][j] = true;
            boolean result = dfs(i + 1, j, len + 1, used, board, word)
                    || dfs(i - 1, j, len + 1, used, board, word)
                    || dfs(i, j + 1, len + 1, used, board, word)
                    || dfs(i, j - 1, len + 1, used, board, word);
            used[i][j] = false;
            return result;
        }
        return false;
    }


    /**
     * 检测边界
     *
     * @param i
     * @param j
     * @param board
     * @return
     */
    private static boolean checkBorder(int i, int j, char[][] board) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char board[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String string = "ABCESEEEFS";
        System.out.println(exist(board, string));
    }
}
