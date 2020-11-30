package 搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taoning
 * @create 2020/11/18
 */
public class _310_最小高度树 {
    /**
     * 查找最小树深度
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            // 计算节点的度
            degree[edge[0]] ++;
            degree[edge[1]] ++;
            // 添加临接节点到List中
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++){
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int cnt = queue.size();
            ans = new ArrayList<>();
            for (int i = 0; i < cnt; i ++){
                int cur = queue.poll();
                ans.add(cur);
                List<Integer> neighbors = map.get(cur);
                // 遍历相邻节点
                for (int neighbor : neighbors){
                    degree[neighbor] --;
                    if (degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return ans;
    }
}
