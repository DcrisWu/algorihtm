package classification.树形DP.code_1377_T秒后青蛙的位置;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * completion time = 2023.8.4
 */
class Solution {

    private ArrayList<Integer>[] g;
    private boolean[] vis;
    private double[] possible;
    private int t;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }
        vis = new boolean[n];
        possible = new double[n];
        possible[0] = 1;
        this.t = t;
        vis[0] = true;
        dfs(0, 0);
        return possible[target - 1];
    }

    void dfs(int time, int f) {
        if (time >= t) {
            return;
        }
        int count = 0;
        for (Integer x : g[f]) {
            if (!vis[x]) {
                count++;
            }
        }
        double kidPossible = possible[f] / count;
        boolean canJump = false;
        for (Integer x : g[f]) {
            if (!vis[x]) {
                canJump = true;
                vis[x] = true;
                possible[x] = kidPossible;
                dfs(time + 1, x);
            }
        }
        // 如果还能跳，那么它不可能停留在f节点，只有它不可能再跳了，它才会有概率停留在f节点
        if (canJump){
            possible[f] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        System.out.println(new Solution().frogPosition(7, edges, 1, 4));
    }
}
