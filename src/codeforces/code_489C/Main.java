package codeforces.code_489C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        // 首先把不成立的情况排除了
        if (m == 1) {
            if (s > 9) {
                System.out.println("-1 -1");
            } else {
                System.out.println(s + " " + s);
            }
            return;
        }
        if (s == 0 || s > m * 9) {
            System.out.println("-1 -1");
            return;
        }
        // 最大值是尽可能塞9
        StringBuilder maxS = new StringBuilder("9".repeat(s / 9));
        if (s % 9 > 0) {
            maxS.append(s % 9);
        }
        // 补充0
        maxS.append("0".repeat(m - maxS.length()));
        StringBuilder minS = new StringBuilder();
        // 如果刚好不需要0填充
        if ((s + 8) / 9 == m) {
            minS.append(s - (m - 1) * 9);
            minS.append("9".repeat(m - 1));
        } else {
            // 如果需要0来填充
            s--;
            minS.append(1);
            minS.append("0".repeat(m - 2 - s / 9));
            minS.append(s % 9);
            minS.append("9".repeat(s / 9));
        }
        System.out.println(minS + " " + maxS);
    }

}
