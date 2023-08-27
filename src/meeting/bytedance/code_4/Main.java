package meeting.bytedance.code_4;

import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public int mod = (int) (1e9 + 7);

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println((cal(r) + mod - cal(l - 1)) % mod);
    }

    private String n;
    private int len;
    // 前i位最大值为j
    private int[][] dp;
    public int cal(int num) {
        n = String.valueOf(num);
        len = n.length();
        dp = new int[len][10];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dfs(0, i, true, false, false)) % mod;
        }
        return res;
    }

    public int dfs(int i, int max, boolean isLimit, boolean isNum, boolean isReach) {
        // 如果长度到达i，同时满足这个数的最大值 == max
        if (i == len) {
            return isReach ? max : 0;
        }
        // 如果前i位的最大值为max的情况已经算出来，同时已经达到过最大值，就直接返回
        if (isReach && isNum && dp[i][max] != -1) {
            return dp[i][max];
        }
        int res = 0;
        if (!isNum) {
            res = dfs(i + 1, max, false, false, false);
        }
        int up = isLimit ? n.charAt(i) - '0' : 9;
        // 保证后续遍历的数的最大值 <= max
        for (int d = isNum ? 0 : 1; d <= up && d <= max; d++) {
            res = (res + dfs(i + 1, max, isLimit && d == up, true, isReach || d == max)) % mod;
        }
        // 如果是受限的，那它只会被遍历一次，不需要记忆化
        // 如果之前还未形成数字，现在是第一个数字，那没必要记忆化，对应 {0, 1, 2, ...,9}
        // 因为dp[i][j]表示前i位，最大值为 j 时候的情况，这个前i位不包括当前位，所以之前还没形成数字，那就不需要记忆化
        if (!isLimit && isNum) {
            dp[i][max] = res;
        }
        return res;
    }

}