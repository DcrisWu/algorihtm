package competition.leetcode_weekly.No_362_day_2023_9_10.code_100030_将石头分散到网格图的最少移动次数;

import java.util.*;

/**
 * completion time = 2023.9.11
 */
class Solution {
    private List<int[]> in;
    private List<int[]> out;
    private boolean[] visit;
    private int ans = Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {
        // 可以使用全排列
        in = new ArrayList<>();
        out = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    in.add(new int[]{i, j});
                }
                for (int k = 1; k < grid[i][j]; k++) {
                    out.add(new int[]{i, j});
                }
            }
        }
        visit = new boolean[in.size()];
        dfs(new ArrayList<>());
        return ans;
    }

    public void dfs(List<int[]> pre) {
        if (pre.size() == visit.length) {
            int now = 0;
            for (int i = 0; i < pre.size(); i++) {
                int[] a = in.get(i);
                int[] b = pre.get(i);
                now += Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
            }
            if (now < ans) {
                ans = now;
            }
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                pre.add(out.get(i));
                visit[i] = true;
                dfs(pre);
                visit[i] = false;
                pre.remove(pre.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 0, 0}, {0, 0, 2}, {3, 0, 0}};
        System.out.println(new Solution().minimumMoves(arr));
    }
}