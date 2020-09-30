package 其他;

/**
 * @author taoning
 * @create 2020/9/29
 */
public class _29两数相除 {
    public int divide(int dividend, int divisor) {
        // 用来标示正负数
        boolean flag = true;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        long a = dividend, b = divisor;
        if (a < 0) {
            a = -a;
            flag = !flag;
        }
        if (b < 0) {
            b = -b;
            flag = !flag;
        }
        long ans = div(a, b);
        if (flag) {
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
        }
        return -(int) ans;
    }

    /**
     * 使用加法计算的方式
     *
     * @param a
     * @param b
     * @return
     */
    private long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tmp_b = b;
        while ((tmp_b + tmp_b) <= a) {
            count += count;
            tmp_b += tmp_b;
        }
        return count + div(a - tmp_b, b);
    }
}
