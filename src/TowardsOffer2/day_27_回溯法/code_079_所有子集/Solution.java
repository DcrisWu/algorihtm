package TowardsOffer2.day_27_回溯法.code_079_所有子集;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.6
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        ans.add(init);
        dfs(ans, 0, nums, init);
        return ans;
    }

    void dfs(List<List<Integer>> ans, int index, int[] nums, List<Integer> pre) {
        for (int i = index; i < nums.length; i++) {
            List<Integer> now = new ArrayList<>(pre);
            now.add(nums[i]);
            ans.add(now);
            dfs(ans, i + 1, nums, now);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        List<List<Integer>> subsets = solution.subsets(arr);
        System.out.println(subsets);
    }
}
