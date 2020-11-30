package 每日一题;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author taoning
 * @create 2020/10/28
 */
public class _1207_独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (set.contains(map.get(key))) {
                return false;
            } else {
                set.add(map.get(key));
            }
        }
        return true;
    }
}
