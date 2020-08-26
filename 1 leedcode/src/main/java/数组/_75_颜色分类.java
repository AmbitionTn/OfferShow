package 数组;

/**
 * 75 颜色分类【中等】
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/sort-colors/
 * @create 2020/08/26
 */
public class _75_颜色分类 {
    /**
     * 一次扫描的算法
     * 遍历一遍，使用left指向最左面，right指向最右面，left ++， right --；
     * 如果发现数值为0则与left交换，如果发现数值为2，怎与right交换
     * 需要注意：将2与右侧交换后，需要判断交换后的数是否要与左侧交换
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 创建做指针和右指针
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(i, left++, nums);
            }
            if (nums[i] == 2) {
                swap(i, right--, nums);
                i--;
            }
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param source_index
     * @param target_index
     * @param arr
     */
    private void swap(int source_index, int target_index, int arr[]) {
        int tmp = arr[source_index];
        arr[source_index] = arr[target_index];
        arr[target_index] = tmp;
    }
}
