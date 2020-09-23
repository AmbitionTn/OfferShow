package 剑指Offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int row = 0, column = matrix[0].length - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            }else if (num > target) {
                column --;
            }else {
                row ++;
            }
        }
        return false;
    }
}
