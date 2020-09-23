package 剑指Offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer11旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int now = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < now) {
                return numbers[i];
            }
        }
        return now;
    }
}
