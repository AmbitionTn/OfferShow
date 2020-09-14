package 其他;

import java.util.Scanner;

/**
 * @author tning
 * @create 2020/09/09
 */
public class _第一题 {
    private static int nums1[];
    private static int nums2[];
    private static int nums3[];
    private static int nums4[];

    public static void main(String[] args) {
        input();
        int n_index = 0;
        // 记录相等的个数
        int cnt = 0;
        while (n_index < nums3.length) {
            if (nums3[n_index] != nums1[0]){
                n_index ++;
                continue;
            }
            // 找到num3中第一个相等的值
            if (nums3[n_index] == nums1[0]) {
                for (int i = 0; i < nums1.length; i++, n_index++) {
                    if (nums1[i] == nums3[n_index] && nums2[i] == nums4[n_index]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
            //找到这个数列了
            if (cnt == nums1.length) {
                System.out.println("1");
                break;
            } else {
                cnt = 0;
            }
        }
        if (cnt != nums1.length){
            System.out.println("0");
        }
    }

    /**
     * 输入函数
     */
    private static void input() {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        nums1 = new int[k];
        nums2 = new int[k];
        for (int i = 0; i < k; i++) {
            nums1[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            nums2[i] = in.nextInt();
        }
        int n = in.nextInt();
        nums3 = new int[n];
        nums4 = new int[n];
        for (int i = 0; i < n; i++) {
            nums3[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums4[i] = in.nextInt();
        }
    }
}
