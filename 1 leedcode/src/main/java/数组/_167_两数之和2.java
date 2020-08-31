package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 167 两数之和 II - 输入有序数组
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @create 2020/08/28
 */
public class _167_两数之和2 {
    /**
     * 解析：使用双指针，left指针从左向右扫描，right从右向左扫描
     * 如果left和right指向的两个数之和等于target直接返回，如果比target大，right--，如果比target小，left++
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left != right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
