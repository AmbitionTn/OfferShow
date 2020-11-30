package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taoning
 * @create 2020/11/26
 */
public class 面试题_17_05_字母与数字 {
    public static String[] findLongestSubarray(String[] array) {
        int pre[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            // 将字符串替换成1和-1  数字为1 字母为-1
            if (array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9') {
                pre[i] = 1;
            } else {
                pre[i] = -1;
            }
        }

        //  求前缀和
        for (int i = 1; i < pre.length; i++) {
            pre[i] += pre[i - 1];
        }

        int max_len = 0, ans_i = 0, ans_j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] == 0 && i > max_len){
                max_len = i;
                ans_i = 0;
                ans_j = i;
                continue;
            }

            if (!map.containsKey(pre[i])) {
                map.put(pre[i], i);
            } else if(i - map.get(pre[i]) > max_len){
                if (((array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9')
                        &&(array[map.get(pre[i])].charAt(0) >= '0'
                        && array[map.get(pre[i])].charAt(0) <= '9'))
                        || (array[i].charAt(0) >= 'A' && array[i].charAt(0) <= 'z')
                        &&(array[map.get(pre[i])].charAt(0) >= 'A'
                        && array[map.get(pre[i])].charAt(0) <= 'z')){
                    max_len = i - map.get(pre[i]);
                    ans_i = map.get(pre[i]);
                    ans_j = i;
                }else {
                    max_len = i - map.get(pre[i]);
                    ans_i = map.get(pre[i]) + 1;
                    ans_j = i;
                }
                max_len = i - map.get(pre[i]);
                ans_i = map.get(pre[i]) + 1;
                ans_j = i;

            }
        }
        return Arrays.copyOfRange(array, ans_i, ans_j + 1);
    }

    public static void main(String[] args) {
        String arr[] = new String[]{"A","1"};
        String ans[] = findLongestSubarray(arr);
        for (String s : ans){
            System.out.print(s + " ");
        }
    }
}
