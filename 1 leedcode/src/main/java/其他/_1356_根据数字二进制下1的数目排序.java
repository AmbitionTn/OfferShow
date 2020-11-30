package 其他;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author taoning
 * @create 2020/11/6
 */
public class _1356_根据数字二进制下1的数目排序 {
    /**
     * 将待排序数组放在List中，通过使用Collections集合排序，获得结果
     * 这个题目就是求一个数的二进制数的简单题目
     *
     * 求二进制中1的个数直接使用 n & (n - 1)就可以判断
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            list.add(a);
        }
        Collections.sort(list, (x, y) -> {
            int xCnt = 0, yCnt = 0;
            int tmpX = x, tmpY = y;
            while(tmpX > 0){
                tmpX &= (tmpX - 1);
                xCnt ++;
            }
            while(tmpY > 0){
                tmpY &= (tmpY - 1);
                yCnt ++;
            }
            if (xCnt == yCnt){
                return x - y;
            }else{
                return xCnt - yCnt;
            }
        });
        int res[] = new int[list.size()];
        int index = 0;
        for(int l : list){
            res[index ++] = l;
        }
        return res;
    }
}
