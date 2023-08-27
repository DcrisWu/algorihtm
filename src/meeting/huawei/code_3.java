package meeting.huawei;

import java.util.*;

public class code_3 {
    static int[][] grip;
    static int[][] dp;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] change = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int beginX = sc.nextInt(), beginY = sc.nextInt();
        grip = new int[m][n];
        visit = new boolean[m][n];
        dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grip[i][j] = sc.nextInt();
            }
        }
        int visitCount = 1;
        visit[beginX][beginY] = true;
        dp[beginX][beginY] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{beginX, beginY});
        while (!q.isEmpty()) {
            int size = q.size();
            List<int[]> temp = new ArrayList<>();
            for (int i = 0;i<size;i++){
                int[] poll = q.poll();
                // 要么是1，要么是2，因为0不会入队
                boolean isOne = grip[poll[0]][poll[1]] == 1;
                if (isOne) {
                    for (int[] c : change) {
                        int x = c[0] + poll[0];
                        int y = c[1] + poll[1];
                        if (check(x, y)) {
                            dp[x][y] = Math.min(dp[x][y], dp[poll[0]][poll[1]] + 1);
                            visit[x][y] = true;
                            visitCount++;
                            if (grip[x][y] != 0) {
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                    if (visitCount == n * m) {
                        break;
                    }
                } else {
                    if (visitCount == n * m) {
                        break;
                    }
                    dp[poll[0]][poll[1]] += 1;
                    grip[poll[0]][poll[1]] = 1;
                    temp.add(poll);
                }

            }
            q.addAll(temp);
        }
        if (visitCount < n * m) {
            System.out.println(-1);
        }else {
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < grip.length && y >= 0 && y < grip[0].length && !visit[x][y];
    }
}
