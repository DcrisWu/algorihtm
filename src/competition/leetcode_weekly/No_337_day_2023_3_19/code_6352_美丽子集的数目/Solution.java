package competition.leetcode_weekly.No_337_day_2023_3_19.code_6352_美丽子集的数目;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.3.19
 */
class Solution {
    private int ans = 0;
    private int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        dfs(nums, 0, set);
        return ans;
    }

    void dfs(int[] nums, int i, Set<Integer> set) {
        for (int m = i; m < nums.length; m++) {
            if (!set.contains(nums[m] - k)) {
                set.add(nums[m]);
                ans++;
                dfs(nums, m + 1, set);
                set.remove(nums[m]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 4, 6};
        System.out.println(solution.beautifulSubsets(arr, 2));
    }
}
