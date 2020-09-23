package 其他;

/**
 * 50. Pow(x, n)
 *
 * @author taoning
 * @URL：https://leetcode-cn.com/problems/powx-n/
 * @create 2020/9/20
 */
public class _50_快速幂 {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        double res = 1.0d;
        long d = n;
        if (n < 0){
            x = 1 / x;
            d = -d;
        }
        while (d != 0){
            if ((d & 1) == 1){
                res *= x;
            }
            x *= x;
            d >>= 1;
        }
        return res;
    }
}
