package TowardsOffers2.code_16_数值的整数次方;

class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            return recursion(x, n);
        } else {
            return 1 / recursion(x, Math.abs((long) n));
        }
    }

    double recursion(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1){
            return x;
        }
        if (n % 2 == 0) {
            return Math.pow(recursion(x, n / 2), 2);
        } else {
            return Math.pow(recursion(x, n / 2), 2) * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, -2147483648));
    }
}
