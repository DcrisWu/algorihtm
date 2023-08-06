package competition.leetcode_weekly.No_357_day_2023_8_6.code_6951_找出最安全路径;

import java.util.*;

/**
 * completion time = 2023.8.6
 *
 * 多源最短路径问题，可以使用bfs解决问题
 */
class Solution {
    private int[][] dis;
    private int[][] change;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        dis = new int[n][n];
        change = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] di : dis) {
            Arrays.fill(di, -1);
        }
        // 多源最短路径问题
        // 使用bfs，查找每一个点到小偷的最短距离
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] ints : change) {
                int x = poll[0] + ints[0], y = poll[1] + ints[1];
                // 如果已经越界 || 是小偷的点 || 已经遍历过，就直接跳过
                if (isExceed(x, y) || dis[x][y] >= 0) {
                    continue;
                }
                q.add(new int[]{x, y});
                // 更新距离小偷的最小距离
                dis[x][y] = dis[poll[0]][poll[1]] + 1;
            }
        }
        // 通过二分法查找
        // 遍历完之后，(0,0)到(n-1,n-1)都记录有离小偷的最小距离，通过二分法，寻找一条路径，这条路径上所有的点到小偷的距离都 >= limit
        // 因为一定要经过(0,0)，(n-1,n-1)，所以这是limit的上限
        int l = 0, r = Math.min(dis[0][0], dis[n - 1][n - 1]);
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // 判断是否越界
    boolean isExceed(int i, int j) {
        return i < 0 || j < 0 || i >= dis.length || j >= dis.length;
    }

    boolean check(int limit) {
        int n = dis.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        // 因为(0,0) >= 上限，所以一定是符合条件的
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] ints : change) {
                int x = poll[0] + ints[0], y = poll[1] + ints[1];
                // 如果越界 || 访问过 || 距离 < limit
                if (isExceed(x, y) || vis[x][y] || dis[x][y] < limit) {
                    continue;
                }
                vis[x][y] = true;
                q.add(new int[]{x, y});
            }
        }
        return vis[n - 1][n - 1];
    }

    public static void main(String[] args) {
        // [[1,0,0],[0,0,0],[0,0,1]]
        List<Integer> t1 = new ArrayList<>();
        t1.add(1);
        t1.add(0);
        t1.add(0);
        List<Integer> t2 = new ArrayList<>();
        t2.add(0);
        t2.add(0);
        t2.add(0);
        List<Integer> t3 = new ArrayList<>();
        t3.add(0);
        t3.add(0);
        t3.add(1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(t1);
        grid.add(t2);
        grid.add(t3);
        System.out.println(new Solution().maximumSafenessFactor(grid));
    }
}
