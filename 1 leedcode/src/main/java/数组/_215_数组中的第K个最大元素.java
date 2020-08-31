package 数组;

/**
 * 215 数组中的第K个最大元素【中等】
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @create 2020/08/27
 */
public class _215_数组中的第K个最大元素 {
    /**
     * 循环四次，找到最小的值
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            len--;
            max_heapify(nums, 0, len);
        }
        return nums[0];
    }

    /**
     * 堆的初始化
     *
     * @param arr
     * @param heapSize
     */
    private void buildMaxHeap(int[] arr, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            max_heapify(arr, i, heapSize);
        }
    }

    /**
     * 最大堆
     *
     * @param arr
     * @param i
     * @param len
     */
    private void max_heapify(int[] arr, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largestIndex = i;
        if (left < len && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }

        if (right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            max_heapify(arr, largestIndex, len);
        }
    }

    /**
     * 交换两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        new ThreadLocal().get();
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
