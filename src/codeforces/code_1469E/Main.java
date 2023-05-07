package codeforces.code_1469E;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * comment：不会，test81不知道为什么过不了
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            if (n == 1) {
                System.out.println("YES");
                System.out.println(s);
            }
            char[] array = s.toCharArray();
            // left表示有偿长为k的字符串，总共有left种
            // 表示s中可能存在的长为k的字符串的种类
            // 如果 left > right，答案一定存在，否则答案可能不存在
            // 同时对于长度为 k 的字符串 t，除了全与t相反的字符串 ~t，其他种类的字符串至少有一位跟t相同，即符合题意
            // 当 k 比较小的时候，答案可能不存在
            Set<Integer> set = new HashSet<>();
            int k2 = Integer.toBinaryString(n).length() - 1;
            int left = k - k2;
            if (left <= 0) {
                for (int j = 0; j <= n - k; j++) {
                    int num = 0;
                    for (int m = j; m < j + k; m++) {
                        num = num << 1 | (array[m] == '0' ? 0 : 1);
                    }
                    set.add(num);
                }
                int max = 1 << k;
                boolean isOut = false;
                for (int j = 0; j < max; j++) {
                    // num表示 t 的反转
                    int num = (j ^ Integer.MAX_VALUE) & (max - 1);
                    if (!set.contains(num)) {
                        System.out.println("YES");
                        StringBuilder ans = new StringBuilder();
                        String binaryString = Integer.toBinaryString(j);
                        ans.append("0".repeat(Math.max(0, k - binaryString.length())));
                        ans.append(binaryString);
                        System.out.println(ans);
                        isOut = true;
                        break;
                    }
                }
                if (!isOut) {
                    System.out.println("NO");
                }
            } else {
                // 当 k 较大时候，答案一定存在
                // n >= n-k+1 => log(n) >= log(n-k+1)，所以字符串 s 最多有 n 位就可以了
                // 所以对于长度为k的子串，前 k-log(n)都初始化为0，只需要遍历后log(n)位就可以了
                // len 表示后半部分
                int len = (int) (Math.log(n) / Math.log(2));
                int max = (int) Math.pow(2, len);
                for (int j = k - len; j <= n - len; j++) {
                    int num = 0;
                    for (int m = j; m < j + len; m++) {
                        num = num << 1 | (array[m] == '0' ? 0 : 1);
                    }
                    set.add(num);
                }
                for (int j = 0; j < max; j++) {
                    // num表示 t 的反转
                    int num = (j ^ Integer.MAX_VALUE) & ((1 << len) - 1);
                    if (!set.contains(num)) {
                        System.out.println("YES");
                        StringBuilder ans = new StringBuilder();
                        String binaryString = Integer.toBinaryString(j);
                        ans.append("0".repeat(Math.max(0, k - binaryString.length())));
                        ans.append(binaryString);
                        System.out.println(ans);
                        break;
                    }
                }
            }

        }
    }
}
