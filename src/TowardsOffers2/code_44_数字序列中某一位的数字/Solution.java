package TowardsOffers2.code_44_数字序列中某一位的数字;

/**
 * completion time = 2023.3.23
 */
class Solution {
    /**
     * digit 表示这个数有多少位， start表示 digit位的数从具体哪个数开始， count 位数是 digit的数有多少个
     *
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start = start * 10;
            count = 9 * start * digit;
        }
        // 获取具体是哪个数
        long num = start + (n - 1) / digit;
        // 这个数的第 (n-1)%digit 就是答案
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(15));
    }
}