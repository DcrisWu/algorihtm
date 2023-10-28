package meeting.shopee.code_1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[] arr = {"abcd", "cbad", "bcad", "dabc"};
        System.out.println(new Solution().numSimilarGroups(arr));
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param strs string字符串 一维数组
     * @return int整型
     */
    public int numSimilarGroups(String[] strs) {
        // write code here
        int n = strs.length;
        int[] g = new int[n];
        Arrays.fill(g, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs[i], strs[j])) {
                    union(g, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i : g) {
            if (i < 0) {
                cnt++;
            }
        }
        return cnt;
    }

    void union(int[] g, int x, int y) {
        int fx = getFa(g, x);
        int fy = getFa(g, y);
        // fx的秩更大
        if (g[fx] < g[fy]) {
            g[fy] = fx;
        } else if (g[x] > g[fy]) {
            g[fx] = fy;
        } else {
            g[fy] = fx;
            g[fx]--;
        }
    }

    int getFa(int[] g, int i) {
        if (g[i] < 0) {
            return i;
        }
        g[i] = getFa(g, g[i]);
        return g[i];
    }

    boolean check(String a, String b) {
        int cnt = 0;
        boolean judge = false;
        int n = a.length();
        char ta = '0', tb = '0';
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
                if (cnt == 1) {
                    ta = a.charAt(i);
                    tb = b.charAt(i);
                } else if (cnt == 2 && a.charAt(i) == tb && b.charAt(i) == ta) {
                    judge = true;
                }
            }
        }
        return cnt == 2 && judge;
    }
}

