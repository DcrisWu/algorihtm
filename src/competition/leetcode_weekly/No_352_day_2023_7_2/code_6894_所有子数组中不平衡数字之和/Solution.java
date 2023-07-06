package competition.leetcode_weekly.No_352_day_2023_7_2.code_6894_所有子数组中不平衡数字之和;

import java.util.*;

/**
 * completion time = 2023.7.2
 * 贡献法还不理解
 */
class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        /*int ans = 0, n = nums.length;
        var vis = new boolean[n + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            vis[nums[i]] = true;
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                int x = nums[j];
                if (!vis[x]) {
                    cnt++;
                    if (vis[x - 1]) cnt--;
                    if (vis[x + 1]) cnt--;
                    vis[x] = true;
                }
                ans += cnt;
            }
        }
        return ans;*/

        // 贡献法
        int n = nums.length;
        var right = new int[n];
        var idx = new int[n + 1];
        Arrays.fill(idx, n);
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            // right[i] 表示 nums[i] 右侧的 x 和 x-1 的最近下标（不存在时为 n）
            right[i] = Math.min(idx[x], idx[x - 1]);
            idx[x] = i;
        }

        int ans = 0;
        Arrays.fill(idx, -1);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            // 统计 x 能产生多少贡献
            ans += (i - idx[x - 1]) * (right[i] - i); // 子数组左端点个数 * 子数组右端点个数
            idx[x] = i;
        }
        // 上面计算的时候，每个子数组的最小值必然可以作为贡献，而这是不合法的
        // 所以每个子数组都多算了 1 个不合法的贡献
        return ans - n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.sumImbalanceNumbers(arr));
    }
}
