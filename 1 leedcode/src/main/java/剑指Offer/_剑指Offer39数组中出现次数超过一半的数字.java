package 剑指Offer;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @create 2020/9/27
 */
public class _剑指Offer39数组中出现次数超过一半的数字 {
    /**
     * 定义一个count 和 cur如果数组和cur相等，则count ++，否则count --
     * 如果count =0 则需要将当前数组中的值设置到cur中
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1, cur = nums[0];
        for (int num : nums) {
            if (num != cur) {
                count--;
                if (count < 0) {
                    cur = num;
                    count = 1;
                }
            }
            count++;
        }
        return cur;
    }
}
