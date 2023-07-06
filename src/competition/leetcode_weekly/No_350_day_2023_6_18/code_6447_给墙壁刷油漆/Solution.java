package competition.leetcode_weekly.No_350_day_2023_6_18.code_6447_给墙壁刷油漆;

/**
 * 从后往前遍历，每次选择刷油漆或者不刷油漆，直到刷完所有的墙壁
 * 选择付费刷漆，就可以获得时间，获得的时间可以用来聘请免费工人
 */
class Solution {
    private int inf = Integer.MAX_VALUE / 2;

    public int paintWalls(int[] cost, int[] time) {
        return dfs(cost.length - 1, 0, cost, time);
    }

    int dfs(int i, int j, int[] cost, int[] time) {
        if (j > i) {
            return 0;
        }
        if (i < 0) {
            return inf;
        }
        return Math.min(dfs(i - 1, j + time[i], cost, time) + cost[i], dfs(i - 1, j - 1, cost, time));
    }

    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};
        Solution solution = new Solution();
        System.out.println(solution.paintWalls(cost, time));
    }
}
