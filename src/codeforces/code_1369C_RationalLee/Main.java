package codeforces.code_1369C_RationalLee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * completion time = 2023.4.17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            int[] w = new int[k];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j = 0; j < k; j++) {
                w[j] = scanner.nextInt();
            }
            System.out.println(getMax(n, k, a, w));
        }
    }

    public static long getMax(int n, int k, int[] a, int[] w) {
        Arrays.sort(w);
        Arrays.sort(a);
        int endIndex = n - 1;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (w[i] == 1) {
                sum += a[endIndex--] * 2L;
            } else {
                sum += a[endIndex--];
            }
            w[i]--;
        }
        int beginIndex = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (w[i] > 0) {
                sum += a[beginIndex++];
                beginIndex += w[i] - 1;
            }
        }
        return sum;
    }
}
