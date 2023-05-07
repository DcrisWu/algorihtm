package competition.leetcode_weekly.No_344_day_2023_5_7.code_6419_使二叉树所有路径值相等的最小代价;

/**
 * completion time = 2023.5.7
 */
class Solution {

    private int[] cost;
    private int count;

    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        this.count = 0;
        dfs(1);
        return count;
    }

    public int dfs(int index) {
        if (index * 2 > cost.length) {
            return cost[index - 1];
        }
        int left = dfs(index * 2);
        int right = dfs(index * 2 + 1);
        int max = Math.max(left, right);
        count += Math.abs(left - right);
        return max + cost[index - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {764, 1460, 2664, 764, 2725, 4556, 5305, 8829, 5064, 5929, 7660, 6321, 4830, 7055, 3761};
        int[] arr = {1, 5, 2, 2, 3, 3, 1};
        System.out.println(solution.minIncrements(7, arr));
    }
}