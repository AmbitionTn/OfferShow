package 搜索;

/**
 * 529 扫雷游戏
 *
 * @author tning
 * @create 2020/08/20
 */
public class _529_扫雷游戏 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] map = new int[board.length][board[0].length];

        //扫描一遍扫描出地图
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'M') {
                    write_map(map, i, j);
                }
            }
        }

        dfs(board, map, click[0], click[1]);
        return board;
    }

    /**
     * 扫描出原始地图
     *
     * @param map 扫描后的雷区分布地图
     * @param row
     * @param col
     * @return
     */
    private void write_map(int[][] map, int row, int col) {
        //扫描雷旁边的8个方向，并修改附近的数字
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    //值为-1代表雷
                    map[row][col] = -1;
                    continue;
                }
                if (checkBoard(map, row + i, col + j)) {
                    if (map[row + i][col + j] != -1) {
                        map[row + i][col + j] += 1;
                    }
                }
            }
        }
    }

    /**
     * 检测是否到达边界
     *
     * @param row
     * @param col
     * @return
     */
    private Boolean checkBoard(int[][] map, int row, int col) {
        //地图最大行数
        int max_row = map.length;
        //地图最大列数
        int max_col = map[0].length;
        //当前点在地图中
        if (row >= 0 && row < max_row && col >= 0 && col < max_col) {
            return true;
        }
        return false;
    }


    /**
     * 使用dfs搜索当前地图
     *
     * @param board 原始地图
     * @param map   雷区分布图
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int[][] map, int i, int j) {
        //超出边界剪枝
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (map[i][j] == -1) {
            board[i][j] = 'X';
            return;
        }
        if (map[i][j] == -2) {
            return;
        }
        if (map[i][j] != 0) {
            board[i][j] = (char) (map[i][j] + '0');
            return;
        }
        map[i][j] = -2;
        board[i][j] = 'B';
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (m == 0 && n == 0) {
                    continue;
                }
                dfs(board, map, i + m, j + n);
            }
        }
    }
}
