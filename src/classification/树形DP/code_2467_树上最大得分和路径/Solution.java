package classification.树形DP.code_2467_树上最大得分和路径;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * completion time = 2023.8.7
 */
class Solution {

    private int[] bobTime;
    private ArrayList<Integer>[] g;
    private int[] amount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        this.amount = amount;
        // 时间从 1 开始算
        dfsBob(-1, bob, 1);
        return dfsAlice(-1, 0, 1);
    }

    // bob的收益不重要，bob对结果的影响只在时间上，在树中 x 到 y 的路径是固定的，所以时间结果唯一
    boolean dfsBob(int f, int x, int t) {
        if (x == 0) {
            bobTime[x] = t;
            return true;
        }
        for (Integer y : g[x]) {
            if (y != f && dfsBob(x, y, t + 1)) {
                bobTime[x] = t;
                return true;
            }
        }
        return false;
    }

    // 遍历到达叶子节点的最大收益，只需要判断到达某一个节点时，是比bob更早到还是一起到还是晚到
    int dfsAlice(int f, int x, int t) {
        int val = 0;
        // 如果比bob更早到达
        if (t < bobTime[x]) {
            val += amount[x];
            // 如果同时到达
        } else if (t == bobTime[x]) {
            val += amount[x] / 2;
        }
        int max = Integer.MIN_VALUE;
        for (Integer y : g[x]) {
            if (y != f) {
                max = Math.max(max, dfsAlice(x, y, t + 1));
            }
        }
        max = max == Integer.MIN_VALUE ? 0 : max;
        return val + max;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int[] amount = {-2, 4, 2, -4, 6};
        System.out.println(new Solution().mostProfitablePath(edges, 3, amount));
    }

}
