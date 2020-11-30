package 排序算法;

/**
 * @author taoning
 * @create 2020/11/2
 */
public class _快速排序 {

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int nums[], int left, int right) {
        if (left < right) {
            int i = left, j = right, tmp = nums[left];
            while (i < j) {
                while (i < j && nums[j] >= tmp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= tmp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = tmp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,4,7,9,2,4,6,8,0,1,2,3,4};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums){
            System.out.println(num);
        }
    }
}
