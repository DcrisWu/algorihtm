package competition.leetcode_weekly.No_341_day_2023_4_16.code_6378_最小化旅行的价格总和;

import java.util.*;

/**
 * completion time = 2023.4.16
 */
class Solution {
    private int[] cnt;
    private ArrayList<Integer>[] g;
    private int[] price;

    /**
     * 本题是一个树，虽然没有根节点，但是所有节点都是相连的，且没有环，所以只要不往父节点递归，都不会重复
     */
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        cnt = new int[n];
        this.price = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        for (int[] trip : trips) {
            getPath(trip[0], -1, trip[1]);
        }
        int[] value = getValue(0, -1);
        return Math.min(value[0], value[1]);
    }

    // 找到从now到end的路径，经过的节点cnt++
    boolean getPath(int now, int father, int end) {
        if (now == end) {
            cnt[now]++;
            return true;
        }
        for (Integer node : g[now]) {
            // 如果通过node可以找到一条到达end的路径
            if (node != father && getPath(node, now, end)) {
                cnt[now]++;
                return true;
            }
        }
        return false;
    }

    // int[0]表示当前节点打半折，int[1]表示当前节点不打折
    int[] getValue(int now, int father) {
        int half = price[now] / 2 * cnt[now];
        int notHaf = price[now] * cnt[now];
        for (Integer node : g[now]) {
            if (node != father) {
                int[] value = getValue(node, now);
                half += value[1];
                notHaf += Math.min(value[0], value[1]);
            }
        }
        return new int[]{half, notHaf};
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        int[] price = {2, 2, 10, 6};
        int[][] trips = {{0, 3}, {2, 1}, {2, 3}};
        int n = 4;
        Solution solution = new Solution();
        System.out.println(solution.minimumTotalPrice(n, edges, price, trips));
    }

}