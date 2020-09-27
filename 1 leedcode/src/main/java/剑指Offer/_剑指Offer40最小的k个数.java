package 剑指Offer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @create 2020/9/25
 */
public class _剑指Offer40最小的k个数 {
    /**
     * 直接使用JAVA优先队列：优先队列默认使用小顶堆，需要大顶堆需要重写比较器
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }
}
