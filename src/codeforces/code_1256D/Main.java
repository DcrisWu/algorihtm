package codeforces.code_1256D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (; q > 0; q--) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            String s = scanner.next();
            int c1 = 0;
            StringBuilder res = new StringBuilder();
            boolean isPrint = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    if (c1 <= k) {
                        res.append(0);
                        k -= c1;
                    } else {
                        res.append("1".repeat((int) (c1 - k)));
                        res.append("0");
                        res.append("1".repeat((int) k));
                        res.append(s.substring(i + 1));
                        System.out.println(res);
                        isPrint = true;
                        break;
                    }
                } else {
                    c1++;
                }
            }
            if (!isPrint) {
                res.append("1".repeat(c1));
                System.out.println(res);
            }
        }
    }
}
