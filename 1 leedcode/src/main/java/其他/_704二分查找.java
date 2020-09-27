package 其他;

/**
 * 704. 二分查找
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/binary-search/
 * @create 2020/9/24
 */
public class _704二分查找 {
    /**
     * 超级简单的二分，没意思
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
