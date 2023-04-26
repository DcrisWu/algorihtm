package codeforces.code_1272D_Remove_One_Element;

import java.util.Arrays;
import java.util.Scanner;

/**
 * completion time = 2023.4.25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = 1;
        //dp[i][0]表示没删过，dp[i][1]表示删过了
        int[][] dp = new int[n][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }
        for (int i = 1; i < n; i++) {
            // example: 4 5 3 6
            // 可以同时满足这两个 if
            // dp[i][1] 可能存在就算删了一个数，还是只能为1的情况
            if (a[i] > a[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (i >= 2 && a[i] > a[i - 2]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 2][0] + 1);
            }
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
    }
}
