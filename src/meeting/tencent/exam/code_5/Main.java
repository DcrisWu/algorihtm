package meeting.tencent.exam.code_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().solution();
    }

    private List<Integer>[] list;
    private StringBuilder[] num;
    private int mod = (int) (1e9 + 7);

    private long max = Long.MIN_VALUE;
    private long now = 0;

    private int[] ans;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        num = new StringBuilder[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            num[i] = new StringBuilder(Integer.toBinaryString(a[i]));
        }
        list = new ArrayList[n];
        Arrays.setAll(list, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = num[i].length() - 1; j >= 0; j--) {
                if (num[i].charAt(j) == '1') {
                    list[i].add(1 << (num[i].length() - j - 1));
                }
            }
        }
        dfs(k);
        long res = 0L;
        for (int an : a) {
            res = (res + an) % mod;
        }
        res = (res + mod - max) % mod;
        System.out.println(res);
    }

    public void dfs(int rest) {
        if (rest == 0) {
            if (now > max) {
                max = now;
            }
            return;
        }
        for (int i = 0; i < list.length; i++) {
            Integer first = list[i].get(0);
            list[i].remove(0);
            now += first;
            dfs(rest - 1);
            now -= first;
            list[i].add(0, first);
        }
    }
}
