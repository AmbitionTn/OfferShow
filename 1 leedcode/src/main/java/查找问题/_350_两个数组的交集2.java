package 查找问题;

import java.util.*;

/**
 * 350 两个数组的交集 II
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @create 2020/08/28
 */
public class _350_两个数组的交集2 {
    /**
     * 解析：使用hashMap 存储，出现多次在value加一
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums1.length);
        List<Integer> ans = new ArrayList<Integer>();
        for (Integer n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        for (Integer n : nums2) {
            if (map.containsKey(n) && map.get(n) > 1) {
                ans.add(n);
                map.put(n, map.get(n) - 1);
                continue;
            }
            if (map.containsKey(n) && map.get(n) == 1) {
                ans.add(n);
                map.remove(n);
                continue;
            }
        }

        int result[] = new int[ans.size()];
        int index = 0;
        for (Integer n : ans) {
            result[index++] = n;
        }
        return result;
    }
}
