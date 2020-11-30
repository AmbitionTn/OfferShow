package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author taoning
 * @create 2020/11/9
 */
public class _973_最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });

        for (int i = 0; i < K; i++) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }

        int len = points.length;
        for (int i = K; i < len; i ++){
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dis < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[] {dis, i});
            }
        }
        int [][]ans = new int[K][2];
        for (int i = 0;  i < K; i ++){
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
