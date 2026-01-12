package daily.year_2026.January.day_12_code_1266_访问所有点的最小时间;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        int ans = 0;
        int x = points[0][0], y = points[0][1];
        for (int i = 1; i < points.length; i++) {
            ans += dis(points[i][0] - x, points[i][1] - y);
            x = points[i][0];
            y = points[i][1];
        }

        return ans;
    }

    int dis(int x, int y) {
        return Math.max(Math.abs(x), Math.abs(y));
    }
}
