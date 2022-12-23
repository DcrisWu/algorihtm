package TowardsOffer2_Special.day_27_回溯法.code_081_允许重复选择元素的组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.11.6
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), ans, 0);
        return ans;
    }

    void dfs(int[] candidates, int begin, int target, List<Integer> have, List<List<Integer>> ans, int sum) {
        for (int i = begin; i < candidates.length; i++) {
            int nowSum = sum + candidates[i];
            if (nowSum > target) {
                break;
            }
            ArrayList<Integer> nowHave = new ArrayList<>(have);
            nowHave.add(candidates[i]);
            if (nowSum == target) {
                ans.add(nowHave);
            } else {
                dfs(candidates, i, target, nowHave, ans, nowSum);
            }
        }
    }

}
