package DFS;

/**
 * 200 岛屿数量
 *
 * @author tning
 * @create 2020/08/17
 *
 * @url: https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i ,j);
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    /**
     * dfs遍历 更新与1相连的位置变为0
     *
     * @param grid 地图
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
