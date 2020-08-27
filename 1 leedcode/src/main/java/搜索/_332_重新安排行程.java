package 搜索;

import java.util.*;

/**
 * 332 重新安排行程[中等]
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/reconstruct-itinerary/
 * @create 2020/08/27
 */
public class _332_重新安排行程 {

    private Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    private List<String> result = new ArrayList<String>();

    /**
     * 通过给定的数组构建有向图
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    /**
     * 搜索当前节点
     *
     * @param curr
     */
    private void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        result.add(curr);
    }
}
