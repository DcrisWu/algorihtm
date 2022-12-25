package TowardsOffers2.code_14_II_剪绳子II;

class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = 1000000007;
        int k = n % 3;
        long res = 1;
        if (k == 0) {
            res = 1;
        } else if (k == 1) {
            res = 4;
            n -= 4;
        } else {
            res = 2;
            n -= 2;
        }
        while (n > 0) {
            res = res * 3 % mod;
            n -= 3;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(283));
    }
}
