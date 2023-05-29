package basicAlgorithm.day_10.code_39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.22
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        List<Integer> path = new LinkedList<>();
        dfs(candidates,target,0, candidates.length, path,ans);
        return ans;
    }

    public void dfs(int[] candidates, int target, int begin, int len, List<Integer> path, List<List<Integer>> ans) {
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] >= 0) {
                List<Integer> integers = new LinkedList<>(path);
                integers.add(candidates[i]);
                if (target - candidates[i] == 0) {
                    ans.add(integers);
                }else {
                    dfs(candidates, target - candidates[i], i, len, integers, ans);
                }
            }else {
                break;
            }
        }
    }
}

