package meeting.jd.code_3;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] ac;
        int[][] baoli;
        int t;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        baoli = new int[n][2];
        ac = new int[n][2];
        for (int i = 0; i < n; i++) {
            ac[i][0] = sc.nextInt();// 时间
            ac[i][1] = sc.nextInt();// 得分
            baoli[i][0] = sc.nextInt();// 时间
            baoli[i][1] = sc.nextInt();// 得分
        }

        // 前t时间内做到的最高分,dp[i][0]表示分数,dp[i][1]表示从哪转移
        int[][] dp = new int[t + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = ac[i][0]; j <= t; j++) {
                if (dp[j - ac[i][0]][0] + ac[i][1] > dp[j][0]) {
                    dp[j][0] = dp[j - ac[i][0]][0] + ac[i][1];
                    dp[j][1] = dp[j - ac[i][0]][1];
                }
            }
            for (int j = baoli[i][0]; j <= t; j++) {
                if (dp[j - baoli[i][0]][0] + baoli[i][1] > dp[j][0]) {
                    dp[j][0] = dp[j - baoli[i][0]][0] + baoli[i][1];
                    dp[j][1] = dp[j - baoli[i][0]][1];
                }
            }
        }
    }
}