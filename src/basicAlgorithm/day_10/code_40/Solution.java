package basicAlgorithm.day_10.code_40;

import java.util.*;

/**
 * completion time = 2022.9.22
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1};
        solution.combinationSum2(arr,2);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> rest = new ArrayList<>();
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            rest.add(candidate);
        }
        List<Integer> con = new LinkedList<>();
        dfs(target, rest, 0, rest.size(), ans, con);
        return ans;
    }

    public void dfs(int target, List<Integer> rest, int begin, int len, List<List<Integer>> ans, List<Integer> path) {
        for (int i = begin; i < len; i++) {
            if(i > 0 && rest.get(i) == rest.get(i-1)){
                continue;
            }
            if (target - rest.get(i) >= 0) {
                List<Integer> tempPath = new LinkedList<>(path);
                List<Integer> tempRest = new ArrayList<>(rest);
                tempPath.add(rest.get(i));
                tempRest.remove(i);
                if (target - rest.get(i) == 0) {
                    ans.add(tempPath);
                } else {
                    dfs(target - rest.get(i), tempRest, i, tempRest.size(), ans, tempPath);
                }
            } else {
                break;
            }
        }
    }
}
