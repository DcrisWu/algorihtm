package codeforces.code_1095C;

import java.util.Scanner;

/**
 * completion time = 2023.4.24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] bits = new int[32];
        int ones = 0;
        for (int i = 0; i < 32; i++) {
            bits[i] = (n & (1 << i)) != 0 ? 1 : 0;
            if (bits[i] != 0) {
                ones++;
            }
        }
        if (ones > k || n < k) {
            System.out.println("NO");
        } else {
            int count = ones;
            for (int i = 31; i > 0; i--) {
                if (bits[i] == 0) {
                    continue;
                }
                int l = 0, r = bits[i];
                int needDecompose = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (mid <= k - count) {
                        needDecompose = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                bits[i] -= needDecompose;
                bits[i - 1] += needDecompose * 2;
                count += needDecompose;
                if (count == k) {
                    break;
                }
            }
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                if (bits[i] != 0) {
                    int pow = (int) Math.pow(2, i);
                    sb.append((pow + " ").repeat(Math.max(0, bits[i])));
                }
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
