package TowardsOffer2_Special.day_37_图.code_110_所有路径;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.16
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        backTrack(ans, init, graph, 0);
        return ans;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> pre, int[][] graph, int index) {
        if (index == graph.length - 1) {
            pre.add(index);
            ans.add(new ArrayList<>(pre));
            pre.remove(pre.size() - 1);
        }
        int len = graph[index].length;
        for (int i = 0; i < len; i++) {
            pre.add(index);
            backTrack(ans, pre, graph, graph[index][i]);
            pre.remove(pre.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2}, {3}, {3}, {}};
        System.out.println(solution.allPathsSourceTarget(arr));
    }
}
