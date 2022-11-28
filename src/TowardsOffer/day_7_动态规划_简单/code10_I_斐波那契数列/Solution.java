package TowardsOffer.day_7_动态规划_简单.code10_I_斐波那契数列;

class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int mod = (int) (1e9 + 7);
        int first = 0, second = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (first + second) % mod;
            first = second;
            second = ans;
        }
        return ans;
    }
}
