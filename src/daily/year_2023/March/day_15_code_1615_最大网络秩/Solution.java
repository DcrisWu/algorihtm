package daily.year_2023.March.day_15_code_1615_最大网络秩;

/**
 * completion time = 2023.3.15
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] road : roads) {
            connect[road[0]][road[1]] = true;
            connect[road[1]][road[0]] = true;
            degree[road[0]] += 1;
            degree[road[1]] += 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int now = degree[i] + degree[j];
                if (connect[i][j]) {
                    now -= 1;
                }
                ans = Math.max(ans, now);
            }
        }
        return ans;
    }

}
