package TowardsOffer2.day_28_回溯法.code_082_含有重复元素集合的组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.11.7
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        dfs(candidates, target, 0, ans, init, 0);
        return ans;
    }

    void dfs(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> pre, int preSum) {
        for (int i = index; i < candidates.length; i++) {
            List<Integer> now = new ArrayList<>(pre);
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int sum = preSum + candidates[i];
            if (sum <= target) {
                now.add(candidates[i]);
                if (sum == target) {
                    ans.add(now);
                } else {
                    dfs(candidates, target, i + 1, ans, now, sum);
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> list = solution.combinationSum2(arr, 8);
        System.out.println(list);
    }
}