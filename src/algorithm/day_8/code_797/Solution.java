package algorithm.day_8.code_797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.20
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2},{3},{3},{}};
        System.out.println(solution.allPathsSourceTarget(arr));
    }

    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> now = new LinkedList<>();
        now.add(0);
        dfs(graph, 0, now);
        return ans;
    }

    public void dfs(int[][] graph, int row, List<Integer> last) {
        if (graph[row].length == 0) {
            return;
        }
        for (int i = 0; i < graph[row].length; i++) {
//            List<Integer> temp = List.copyOf(last);
            List<Integer> temp = new LinkedList<Integer>(last);
            temp.add(graph[row][i]);
            if (graph[row][i] == graph.length - 1) {
                ans.add(temp);
            }
            dfs(graph, graph[row][i], temp);
        }
    }
}
