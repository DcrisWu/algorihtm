package meeting.bytedance.code_3;

import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.solution();
    }

    public int mod = (int) (1e9 + 7);
    private int n;
    private long[][] dp;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n][10];
        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(get(n));
    }

    public int get(int max) {
        int now = 0;
        for (int i = 0; i < max; i++) {
            now = (now + cal(i)) % mod;
        }
        return now;
    }

    public int cal(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                even += s.charAt(i) - '0';
            } else {
                odd += s.charAt(i) - '0';
            }
        }
        return odd * even;
    }

    public long dfs(int i, int pre, long odd, long even) {
        return 0;
    }
}