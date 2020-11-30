package 每日一题;

import sun.dc.pr.PRError;

import java.util.Arrays;

/**
 * @author taoning
 * @create 2020/10/30
 */
public class _463_岛屿的周长 {

    private int ans = 0;

    public int islandPerimeter(int[][] grid) {
        boolean used[][] = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(used, grid, i, j);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        return ans;
    }

    /**
     * 深度搜索
     */
    private void dfs(boolean used[][], int[][] grid, int i, int j) {
        if (checkBorder(grid, i, j) && !used[i][j] && grid[i][j] == 1) {
            ans += cal(grid, i, j);
            used[i][j] = true;
            dfs(used, grid, i, j - 1);
            dfs(used, grid, i, j + 1);
            dfs(used, grid, i - 1, j);
            dfs(used, grid, i + 1, j);
        }
    }

    /**
     * 检测是否越界与是否满足条件
     *
     * @return
     */
    private boolean checkBorder(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        return true;
    }

    /**
     * 计算每一个1节点的周长
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int cal(int[][] grid, int i, int j) {
        int res = 0;
        if (i == 0) {
            res++;
        }
        if (i == grid.length - 1) {
            res++;
        }
        if (j == 0) {
            res++;
        }
        if (j == grid[0].length - 1) {
            res++;
        }
        // 左侧
        if (i > 0 && grid[i - 1][j] == 0) {
            res++;
        }
        // 右侧
        if (i < grid.length - 1 && grid[i + 1][j] == 0) {
            res++;
        }
        // 上侧
        if (j > 0 && grid[i][j - 1] == 0) {
            res++;
        }
        // 下册
        if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
            res++;
        }
        return res;
    }
}
