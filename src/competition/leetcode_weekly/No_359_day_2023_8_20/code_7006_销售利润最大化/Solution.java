package competition.leetcode_weekly.No_359_day_2023_8_20.code_7006_销售利润最大化;

import java.util.*;

/**
 * completion time = 2023.8.20
 */
class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort(Comparator.comparingInt(a -> a.get(1)));
        int m = offers.size();
        int[] dp = new int[m];
        dp[0] = offers.get(0).get(2);
        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1], offers.get(i).get(2));
            int l = 0, r = i - 1;
            int t = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (offers.get(mid).get(1) < offers.get(i).get(0)) {
                    t = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (t != -1) {
                dp[i] = Math.max(dp[i], dp[t] + offers.get(i).get(2));
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[][] arr =
                {{0, 0, 5}, {3, 3, 1}, {1, 2, 5}, {0, 0, 7}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> temp = new ArrayList<>();
            for (int anInt : ints) {
                temp.add(anInt);
            }
            list.add(temp);
        }
        System.out.println(new Solution().maximizeTheProfit(5, list));
    }
}