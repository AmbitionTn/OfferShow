package 查找问题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1 两数之和
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/two-sum/
 * @create 2020/08/28
 */
public class _1_两数之和 {
    /**
     * 解析：使用HashMap保存映射关系，key为值，value为下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
