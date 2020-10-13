package 其他;

/**
 * @author taoning
 * @create 2020/10/13
 */
public class _231_2的幂 {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }
}
