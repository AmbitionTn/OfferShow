package 搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/permutations/
 * @create 2020/9/24
 */
public class _46全排列 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    /**
     * 使用回溯算法，进行遍历
     *
     * @param nums
     * @param track
     */
    private void backTrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }

}
