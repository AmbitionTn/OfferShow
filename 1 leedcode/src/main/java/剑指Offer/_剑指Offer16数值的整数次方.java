package 剑指Offer;

public class _剑指Offer16数值的整数次方 {
    public double myPow(double x, int n) {
        long b = n;
        double res = 1.0d;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }

        while (b > 0) {
            if ((b & 1)==1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
