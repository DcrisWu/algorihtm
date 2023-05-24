package codeforces.code_229B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n个点，m条边
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a - 1].add(new int[]{b - 1, c});
            g[b - 1].add(new int[]{a - 1, c});
        }
        ArrayList<int[]>[] t = new ArrayList[n];
        Arrays.setAll(t, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int pre = -2;
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int time = sc.nextInt();
                if (time != pre + 1) {
                    t[i].add(new int[]{time, time});
                }
            }
        }

    }
}
