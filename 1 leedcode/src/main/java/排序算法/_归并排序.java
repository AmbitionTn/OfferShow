package 排序算法;

/**
 * 手写归并排序
 *
 * @author taoning
 * @create 2020/9/29
 */
public class _归并排序 {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int array[], int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(array, L, mid);
        sort(array, mid + 1, R);
        merge(array, L, mid, R);
    }

    /**
     * 合并两个数组
     *
     * @param array
     * @param L
     * @param mid
     * @param R
     */
    private static void merge(int[] array, int L, int mid, int R) {
        int temp[] = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }

        while (p2 <= R) {
            temp[i++] = array[p2++];
        }

        for (int tmp : temp) {
            array[L++] = tmp;
        }
    }
}
