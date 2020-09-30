package 排序算法;

import java.util.Arrays;

/**
 * @author taoning
 * @create 2020/9/29
 */
public class _堆排序 {

    public int[] sort(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);

        int len = res.length;
        buildMaxHeap(res, len);

        for (int i = len - 1; i > 0; i--) {
            swap(res, 0, i);
            len--;
            heapify(res, 0, len);
        }
        return res;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 堆牌核心方法
     *
     * @param arr
     * @param i
     * @param len
     */
    private void heapify(int[] arr, int i, int len) {
        int left = i << 2 + 1;
        int right = i << 2 + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }
    }

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
