package 查找问题;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

/**
 * 349 两个数组的交集
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @create 2020/08/28
 */
public class _349_两个数组的交集 {
    /**
     * 解析：将其中一个数组放在set中，用于判断第二个数组是否与第一个数组有交集，如果遍历第二个数组过程中发现set中已经存在
     * 则加入结果集中。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        for (Integer n : nums1) {
            set.add(n);
        }

        for (Integer n : nums2) {
            if (set.contains(n)) {
                ans.add(n);
                set.remove(n);
            }
        }
        int index = 0;
        int output[] = new int[ans.size()];
        for (Integer n : ans) {
            output[index++] = n;
        }
        return output;
    }
}
