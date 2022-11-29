package TowardsOffer.day_8_动态规划_简单.code_10_II_青蛙跳台阶问题;

class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int mod = (int) (1e9 + 7);
        int first = 1, second = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = (first + second) % mod;
            first = second;
            second = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(7));
    }
}