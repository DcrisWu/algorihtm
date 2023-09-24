package competition.leetcode_weekly.No_363_day_2023_9_17.code_100033_最大合金数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 第3题
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int cal = cal(stock, cost, composition.get(i), budget);
            if (cal > ans) {
                ans = cal;
            }
        }
        return ans;
    }

    int cal(List<Integer> stock, List<Integer> cost, List<Integer> base, int budge) {
        int l = 0, r = Integer.MAX_VALUE;
        // 最多制造ans份
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            long c = 0;
            for (int i = 0; i < base.size(); i++) {
                long want = (long) base.get(i) * mid;
                if (want > stock.get(i)) {
                    long nc = (want - stock.get(i)) * cost.get(i);
                    if (nc > budge) {
                        c = nc;
                        break;
                    }
                    c += nc;
                }
            }
            if (c <= budge) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int budge = 15;
        List<List<Integer>> composite = new ArrayList<>();
        composite.add(Arrays.asList(1, 1, 1));
        composite.add(Arrays.asList(1, 1, 10));
        List<Integer> stock = new ArrayList<>(Arrays.asList(0, 0, 10));
        List<Integer> cost = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(new Solution().maxNumberOfAlloys(n, k, budge, composite, stock, cost));

    }
}
