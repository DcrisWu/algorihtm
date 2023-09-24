package competition.leetcode_weekly.No_363_day_2023_9_17.code_8041_完全子集的最大元素和;

import java.util.List;

class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        int[] plus = new int[1 + n];
        for (int i = 1; i < n; i++) {
            plus[i] = i * i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int now = nums.get(i);
            int idx = i + 1;
            for (int j = 1; j <= n; j++) {
                if (plus[j] / idx > n) {
                    break;
                }
                if (plus[j] % idx == 0 && plus[j] / idx <= n) {
                    now += nums.get((plus[j] / idx) - 1);
                }
            }
            if (now > ans) {
                ans = now;
            }
        }
        return ans;
    }
}