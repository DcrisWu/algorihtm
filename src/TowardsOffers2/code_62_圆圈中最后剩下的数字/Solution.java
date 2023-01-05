package TowardsOffers2.code_62_圆圈中最后剩下的数字;

class Solution {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
