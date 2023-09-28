package meeting.jinshan.code_2;

import java.util.Scanner;

/**
 * completion time = 2023.9.28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        long ans = 0L;
        // 假设已经确定要 i 份礼包 2
        int x = 0, y = m;
        while (x <= n && y >= 1) {
            if (x * 2 + y > n || x + y * 2 > m) {
                y--;
            } else {
                long temp = (long) x * a + (long) y * b;
                ans = Math.max(temp, ans);
                x++;
            }
        }
        x = n;
        y = 0;
        while (x >= 1 && y <= m) {
            if (x * 2 + y > n || x + y * 2 > m) {
                x--;
            } else {
                long temp = (long) x * a + (long) y * b;
                ans = Math.max(temp, ans);
                y++;
            }
        }
        System.out.println(ans);
    }
}
