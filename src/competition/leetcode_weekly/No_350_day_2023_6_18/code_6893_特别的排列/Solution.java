package competition.leetcode_weekly.No_350_day_2023_6_18.code_6893_特别的排列;


import java.util.Arrays;

class Solution {
    private int mod = (int) (1e9 + 7);

    public int specialPerm(int[] nums) {
        int n = nums.length;
        int m = 1 << n;
        // i表示未选的集合，因为最多有14个数，使用二进制表示当前集合中存在的元素，1表示下表为i的元素存在，否则不存在
        // j表示已经选取的元素集合中，最后一个选择的元素
        // 使用记忆化的原因是
        // 1, 2, 3, ....
        // 2, 1, 3, ....
        // 当前面所选的元素都相同，且最后一个元素相同时，剩下的元素排列组合是固定的，可以记忆化搜索
        int[][] memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs((m - 1) ^ (1 << i), i, memo, nums)) % mod;
        }
        return ans;
    }

    int dfs(int i, int j, int[][] memo, int[] nums) {
        // 所有集合都已经遍历过，符合要求直接返回1
        if (i == 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        for (int k = 0; k < nums.length; k++) {
            if (((1 << k) & i) > 0 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)) {
                res = (res + dfs((i ^ (1 << k)), k, memo, nums)) % mod;
            }
        }
        memo[i][j] = res;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {2, 3, 6};
        int[] arr = {20, 100, 50, 5, 10, 70, 7};
        System.out.println(solution.specialPerm(arr));
    }
}