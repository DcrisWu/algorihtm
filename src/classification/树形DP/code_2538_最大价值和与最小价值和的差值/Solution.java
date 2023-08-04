package classification.树形DP.code_2538_最大价值和与最小价值和的差值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

class Solution {

    private int[] price;
    private ArrayList<Integer>[] g;
    private long ans;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        dfs(-1, 0);
        return ans;
    }

    // 返回带叶子的最大路径和，以及不带叶子的最大路径和
    // 叶子指的是入度为1的节点
    long[] dfs(int f, int x) {
        long p = price[x], maxS1 = p, maxS2 = 0;
        for (Integer y : g[x]) {
            if (f != y) {
                long[] res = dfs(x, y);
                long s1 = res[0];
                long s2 = res[1];
                // 前面最大带叶子的路径和 + 当前不带叶子的路径和
                // 前面最大不带叶子的路径和 + 当前带叶子的路径和
                ans = Math.max(ans, Math.max(maxS1 + s2, s1 + maxS2));
                // 可知，maxS2 是 maxS1 路径上少一个叶子节点的结果
                maxS1 = Math.max(maxS1, s1 + p);
                maxS2 = Math.max(maxS2, s2 + p);
            }
        }
        return new long[]{maxS1, maxS2};
    }
}
