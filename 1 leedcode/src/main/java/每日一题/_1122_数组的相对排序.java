package 每日一题;

import java.util.*;

/**
 * @author taoning
 * @create 2020/11/14
 */
public class _1122_数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++){
            map.put(arr2[i], i);
        }
        List<Integer> arr2HaveNumList = new ArrayList<>();
        List<Integer> arr2NotHaveNumList = new ArrayList<>();
        for (int num : arr1){
            if (map.containsKey(num)){
                arr2HaveNumList.add(num);
            }else{
                arr2NotHaveNumList.add(num);
            }
        }
        arr2HaveNumList.sort(Comparator.comparingInt(map::get));
        arr2NotHaveNumList.sort(Comparator.comparingInt(x -> x));
        int index = 0;
        for (int num : arr2HaveNumList){
            arr1[index ++] = num;
        }
        for (int num : arr2NotHaveNumList){
            arr1[index ++] = num;
        }
        return arr1;
    }
}
