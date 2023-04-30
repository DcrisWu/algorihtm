package competition.leetcode_weekly.No_343_day_2023_4_30.code_6343_前往目标的最小代价;

import java.util.Arrays;

/**
 * completion time = 2023.4.30
 */
class Solution {
    // 使用dijkstra算法
    // 只需要把起点，终点，特殊路径的终点作为图中的点就可以了
    // 因为除去走了特殊路径的部分，走的最短路径相当于从起点直接走到了终点，不用在乎中间节点
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length;
        int[] dis = new int[n + 2];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dis, INF);
        // dis[n] 表示起点到start的距离
        // dis[n+1]表示起点到target的距离
        int t = n + 1;
        dis[n] = 0;
        boolean[] visit = new boolean[n + 2];
        while (true) {
            int x = -1;
            for (int i = 0; i < dis.length; i++) {
                if (!visit[i] && (x == -1 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            // 如果已经找到了终点，就直接返回
            if (x == t) {
                return dis[t];
            }
            // 标记这个点已经访问过，表示已经找到了到x的最短路径
            visit[x] = true;
            int vx = 0, vy = 0;
            if (x == n) {
                vx = start[0];
                vy = start[1];
            } else {
                vx = specialRoads[x][2];
                vy = specialRoads[x][3];
            }
            // 更新到其余点的最短路径
            for (int i = 0; i < dis.length; i++) {
                if (!visit[i]) {
                    if (i > n) {
                        int tmp = dis[x] + Math.abs(target[0] - vx) + Math.abs(target[1] - vy);
                        if (tmp < dis[i]) {
                            dis[i] = tmp;
                        }
                    } else {
                        int x1 = specialRoads[i][0], y1 = specialRoads[i][1], cost = specialRoads[i][4];
                        // 走到特殊路径的起点 + 走特殊路径，取最小值，赋值给到特殊路径终点的距离
                        int tmp = dis[x] + Math.abs(vx - x1) + Math.abs(vy - y1) + cost;
                        if (tmp < dis[i]) {
                            dis[i] = tmp;
                        }
                    }
                }
            }
        }
    }
}
