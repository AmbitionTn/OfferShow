package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoning
 * @create 2020/9/12
 */
public class _377_组合总和4 {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return 0;
    }

    private int dfs(Map<Integer, Integer> map, int begin, int[] nums, int target, int len) {
        if (target == 0) {
            return len;
        }

        if (target < 0) {
            return 0;
        }

        for (int i = begin; i < nums.length; i++) {
            int cnt = dfs(map, i, nums, target - nums[i], len++);
        }
        return 0;
    }
}
