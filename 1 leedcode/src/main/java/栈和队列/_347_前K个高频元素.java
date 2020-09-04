package 栈和队列;

import java.util.*;

/**
 * 347 前 K 个高频元素
 *
 * @author tning
 * @URL:https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @create 2020/09/01
 */
public class _347_前K个高频元素 {
    /**
     * 使用小顶堆存储前k个元素，当新的元素进来的时候需要重新排序
     * 这里使用的官方提供的优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 元素放入map中统计出现的次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 使用优先队列 小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });

        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        int[] result = new int[priorityQueue.size()];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek());
        }
        return result;
    }
}
