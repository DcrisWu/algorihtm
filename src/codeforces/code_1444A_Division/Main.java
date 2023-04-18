package codeforces.code_1444A_Division;

import java.util.Scanner;

/**
 * completion time = 2023.4.18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (; T > 0; T--) {
            long p = scanner.nextLong();
            long q = scanner.nextLong();
            System.out.println(getAns(p, q));
        }
    }

    public static long getAns(long p, long q) {
        // 如果 p 不是 q 的倍数，答案就是 p
        if (p % q != 0) {
            return p;
        }
        long ans = 0;
        // i 是 q 的质因子
        // 遍历 q 的每个质因子（必然都是 p 的质因子），因为 p 是 q 的倍数，因为 q 可能比较小，所以遍历 q 的质因子快一点
        for (long i = 2L; i * i <= q; i++) {
            if (q % i != 0) {
                continue;
            }
            long x = p;
            // 如果 x 是 q 的倍数，x 就除以这个质因子，p一定是x的倍数
            while (x % q == 0) {
                x /= i;
            }
            // 我们希望 x 尽可能大，并且 x % q != 0
            // 只需要穷举每一次 p % 质因子后的 x，取 x 的最大值
            ans = Math.max(ans, x);
            q /= i;
            // 更新q的质因子
            while (q % i == 0) {
                q /= i;
            }
        }
        if (q > 1) {
            while (p % q == 0) {
                p /= q;
            }
            ans = Math.max(ans, p);
        }
        return ans;
    }
}
