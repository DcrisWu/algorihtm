package daily.year_2023.January.day_10_code_753_破解保险箱;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.crackSafe(3, 2));
    }

    private int mod;
    private int k;
    private Set<Integer> seen;
    private StringBuilder ans;

    public String crackSafe(int n, int k) {
        this.k = k;
        mod = (int) Math.pow(10, n - 1);
        seen = new HashSet<>();
        ans = new StringBuilder();
        dfs(0);
        ans.append("0".repeat(Math.max(0, n - 1)));
        return ans.toString();
    }

    void dfs(int pre) {
        for (int i = 0; i < k; i++) {
            int now = pre * 10 + i;
            if (!seen.contains(now)) {
                seen.add(now);
                dfs(now % mod);
                ans.append(i);
            }
        }
    }
}
