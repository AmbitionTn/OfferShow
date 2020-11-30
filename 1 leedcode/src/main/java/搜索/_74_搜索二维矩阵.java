package 搜索;

/**
 * @author taoning
 * @create 2020/11/9
 */
public class _74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                continue;
            }
            if (target >= matrix[i][0]) {
                index = i;
            } else {
                break;
            }
        }

        return binarySearch(matrix[index], target);
    }

    /**
     * 通过二分查找，找出target
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
