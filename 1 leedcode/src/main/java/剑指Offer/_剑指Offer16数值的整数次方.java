package 剑指Offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @create 2020/9/23
 */
public class _剑指Offer16数值的整数次方 {

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double sum = 1.0;
        while (n > 0) {
            if ((n & 1) != 0) {
                sum *= x;
            }
            n = n >> 1;
            x *= x;
        }
        return sum;
    }
}
