package codeforces.code_1344A_Hilbert_Hotel;

import java.util.Scanner;

/**
 * completion time = 2023.4.19
 */
public class Main {
    /**
     * a[k1 mod n] + k1 ≠ a[k2 mod n] + k2
     * 设 k1 = p1 * n + i, k2 = p2 * n + j
     * a[i] + p1 * n + i != a[j] + p2 * n + j
     * (a[i] + p1 * n + i) mod n != (a[j] + p2 * n + j) mod n
     * a[i] + i != a[j] + j, a[i] + i >= 0
     * 就需要处理 ((a[i] + i) % n + n) % n
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(judge(n, a) ? "YES" : "NO");
        }
    }

    public static boolean judge(int n, int[] a) {
        boolean[] present = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 下标很容易弄错
            int index = ((a[i] + i) % n + n) % n;
            if (present[index]) {
                return false;
            }
            present[index] = true;
        }
        return true;
    }
}
