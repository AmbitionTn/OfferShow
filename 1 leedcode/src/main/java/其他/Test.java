package 其他;

public class Test {
    public double myPow(double x, int n) {
        double ans = 1.0d;
        long tmp = n;
        if (n < 0){
            tmp = -tmp;
            x = 1 / x;
        }
        while (tmp > 0){
            if ((tmp & 1) == 1){
                ans *= x;
            }
            tmp >>= 1;
            x *= x;
        }
        return ans;
    }
}
