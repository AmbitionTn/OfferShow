package 搜索;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841 钥匙和房间
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/keys-and-rooms/
 * @create 2020/08/31
 */
public class _841_钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int visit[] = new int[rooms.size()];
        bfs(rooms, visit);
        for (int tmp : visit) {
            if (tmp == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用bfs广度优先搜索
     *
     * @param rooms
     */
    public void bfs(List<List<Integer>> rooms, int visit[]) {
        // 创建一个队列
        Queue<Integer> queue = new LinkedList<Integer>();
        // 将0号数组对应的房间钥匙都加入队列中
        for (Integer room : rooms.get(0)) {
            queue.add(room);
        }
        // 0号房间已经进入
        visit[0] = 1;

        while (!queue.isEmpty()) {
            // 出队列一个
            Integer roomTmp = queue.poll();
            if (visit[roomTmp] == 1) {
                continue;
            }
            visit[roomTmp] = 1;
            // 将当前房间对应的钥匙加入队列中
            for (Integer room : rooms.get(roomTmp)) {
                queue.add(room);
            }
        }
    }

    /**
     * 使用深度优先搜索
     *
     * @param rooms
     * @param visit
     * @param index
     */
    public void dfs(List<List<Integer>> rooms, int visit[], int index) {
        visit[index] = 1;
        for (Integer room : rooms.get(index)) {
            // 房间没有进来过
            if (visit[room] == 1) {
                dfs(rooms, visit, room);
            }
        }
    }
}
