package classification.树形DP.code_2646_最小化旅行的价格总和;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * completion time = 2023.8.7
 * 第二次做
 */
class Solution {
    private ArrayList<Integer>[] g;
    private int[] price;
    private int[] cnt;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        this.price = price;
        this.cnt = new int[n];
        for (int[] trip : trips) {
            path(-1, trip[0], trip[1]);
        }
        int[] ans = getPrice(0, -1);
        return Math.min(ans[0], ans[1]);
    }

    // 寻找起点到终点的路径，路过的节点，cnt++
    boolean path(int f, int x, int end) {
        if (x == end) {
            cnt[x]++;
            return true;
        }
        for (Integer y : g[x]) {
            if (y != f) {
                boolean b = path(x, y, end);
                if (b) {
                    cnt[x]++;
                    return true;
                }
            }
        }
        return false;
    }

    // int[0]表示当前节点减半，int[1]表示当前节点原价
    // dfs遍历，但是当前节点的花费是价格 * cnt[x]
    int[] getPrice(int x, int f) {
        int half = price[x] / 2 * cnt[x];
        int remain = price[x] * cnt[x];
        for (Integer y : g[x]) {
            if (y != f) {
                int[] p = getPrice(y, x);
                half += p[1];
                remain += Math.min(p[0], p[1]);
            }
        }
        return new int[]{half, remain};
    }
}
