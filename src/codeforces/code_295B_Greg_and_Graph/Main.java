package codeforces.code_295B_Greg_and_Graph;

import java.util.Scanner;

/**
 * completion time = 2023.4.26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        long[] ans = new long[n];
        for (int k = 0; k < n; k++) {
            ans[k] = scanner.nextInt() - 1;
        }
        boolean[] vist = new boolean[n];
        // 倒序遍历，相当于添加ans[i]节点后，求已添加节点中最短路径的和
        for (int k = n - 1; k >= 0; k--) {
            int node = (int) ans[k];
            vist[node] = true;
            ans[k] = 0;
            // floyd算法，O(n^2)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 因为只是新加入了node，所以只要考虑这个新加的节点会不会影响原来的结果
                    int w = a[i][node] + a[node][j];
                    if (w < a[i][j]) {
                        a[i][j] = w;
                    }
                    // 设 i 和 j 为已经遍历过的点，a[i][j]就是已遍历过的点当中的最短距离
                    if (vist[i] && vist[j]) {
                        ans[k] += a[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println(ans[i] + " ");
        }
        System.out.println(ans[n - 1]);
    }
}
