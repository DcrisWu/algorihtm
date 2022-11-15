package TowardsOffer2.day_36_图.code_106_二分图;

/**
 * completion time = 2022.11.15
 */
class Solution {
    private int[] state;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        state = new int[graph.length];
        this.graph = graph;
        for (int i = 0; i < graph.length; i++) {
            if (state[i] != 0) {
                continue;
            }
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int i) {
        boolean ifTrue = true;
        if (state[i] == 0) {
            state[i] = 1;
        }
        for (int j = 0; j < graph[i].length; j++) {
            if (state[graph[i][j]] == state[i]) {
                return false;
            }
            if (state[graph[i][j]] == 0) {
                state[graph[i][j]] = state[i] == 1 ? 2 : 1;
                ifTrue &= dfs(graph[i][j]);
            }
        }
        return ifTrue;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{0,2},{1,3},{0,2}};
        Solution solution = new Solution();
        System.out.println(solution.isBipartite(arr));
    }
}