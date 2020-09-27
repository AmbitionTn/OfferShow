package 其他;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @create 2020/9/24
 */
public class _34在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 和简单的二分没有区别，只需要判断一下最后的边界，同时当相等的时候缩小区间，不要return，不要return
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = findLeftBound(nums, target);
        ans[1] = findRightBound(nums, target);
        return ans;
    }

    /**
     * 寻找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找右边界
     *
     * @param nums
     * @param target
     * @return
     */
    private int findRightBound(int nums[], int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
