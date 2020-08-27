package 搜索;

/**
 * 695 岛屿的最大面积
 *
 * @author tning
 * @create 2020/08/17
 *
 * @url https://leetcode-cn.com/problems/max-area-of-island/submissions/
 */
public class _695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    /**
     * DFS 深度优先遍历
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dfs(int[][] grid, int i, int j) {
        if (grid == null) {
            return 0;
        }

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        return 1 + dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1) +
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j);
    }
}
