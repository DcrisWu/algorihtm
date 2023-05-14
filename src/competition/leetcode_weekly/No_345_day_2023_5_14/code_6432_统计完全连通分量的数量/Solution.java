package competition.leetcode_weekly.No_345_day_2023_5_14.code_6432_统计完全连通分量的数量;

import java.util.*;

/**
 * completion time = 2023.5.14
 */
class Solution {
    private int[] root;

    public int countCompleteComponents(int n, int[][] edges) {
        // 使用并查集
        // root[i] < 0 表示这是根， | root[i] | 表示这个集合的秩
        // 秩表示这个集合高度的上限，并不一定等于这个高度，因为在find过程中存在路径压缩
        // 只有当集合中的点都 >= 0 才可以用负数的绝对值表示秩的大小
        int[] root = new int[n];
        Arrays.fill(root, -1);
        this.root = root;
        boolean[][] path = new boolean[n][n];
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            path[edge[0]][edge[1]] = true;
            path[edge[1]][edge[0]] = true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = find(i);
            map.putIfAbsent(r, new HashSet<>());
            map.get(r).add(i);
        }
        int count = 0;
        for (Set<Integer> value : map.values()) {
            int e = 0;
            for (Integer v : value) {
                for (int i = 0; i < n; i++) {
                    if (path[v][i]) {
                        e++;
                    }
                }
            }
            int dots = value.size();
            if (e == dots * (dots - 1)) {
                count++;
            }
        }
        return count;
    }

    int find(int x) {
        // 如果 x 就是根，直接返回
        if (root[x] < 0) {
            return x;
        }
        // 如果 x 不是根，就压缩路径，让root[x]直接指向他的根
        root[x] = find(root[x]);
        return root[x];
    }

    // 合并 x 和 y 的根，合并的过程中不考虑压缩路径
    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        // 如果 x 和 y 属于两个不同的集合的话
        if (xRoot != yRoot) {
            // 如果 x 的秩更大
            if (root[xRoot] < root[yRoot]) {
                root[y] = xRoot;
            } else if (root[xRoot] > root[yRoot]) {
                root[x] = yRoot;
            } else {
                // 如果两个的秩一样大
                // 合并两个根
                root[xRoot] = yRoot;
                // y的根的秩--
                root[yRoot]--;
            }
        }
    }
}
