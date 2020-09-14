package 其他;

/**
 * @author taoning
 * @create 2020/9/11
 */
public class _2的n次方 {

    public static String cal(long n) {
        if (n <= 63) {
            return String.valueOf((long)(Math.pow(2, n)));
        }
        n -= 63;
        String start = String.valueOf((long)(Math.pow(2, n)));
        while (n > 0) {
            int carry = 0;
            StringBuffer string = new StringBuffer();
            for (int i = start.length() - 1; i >=0 ; i--) {
                string.append(((start.charAt(i) - '0') * 2 + carry) % 10);
                carry = ((start.charAt(i) - '0') * 2 + carry) / 10;
            }
            if (carry != 0)
                string.append(carry);
            start = string.reverse().toString();
            n --;
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(cal(1000));
    }
}
