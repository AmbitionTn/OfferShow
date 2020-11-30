package 每日一题;

/**
 * @author taoning
 * @create 2020/11/19
 */
public class _283_移动零 {
    /**
     * 超级简单：直接覆盖
     * @param nums
     */
    public  void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums){
            if (num != 0){
                nums[index ++] = num;
            }
        }
        for (int i = index; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}
