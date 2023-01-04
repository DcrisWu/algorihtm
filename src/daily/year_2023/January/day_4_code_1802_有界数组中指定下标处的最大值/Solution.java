package daily.year_2023.January.day_4_code_1802_有界数组中指定下标处的最大值;

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int have = n;
        int ans = 1;
        while (have <= maxSum) {
            if (l == 0 && r == n - 1) {
                int rest = maxSum - have;
                int level = rest / n;
                if (level == 0) {
                    break;
                }
                ans += level;
                have += level * n;
            } else {
                have += r - l + 1;
                ans++;
                l = Math.max(0, l - 1);
                r = Math.min(r + 1, n - 1);
            }
        }
        return have <= maxSum ? ans : ans - 1;
    }
}
