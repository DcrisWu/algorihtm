package daily.year_2022.November.day_29_code_1758_生成交替二进制字符串的最少操作数;

/**
 * completion time = 2022.11.29
 */
class Solution {
    public int minOperations(String s) {
        int zero = 0;
        int one = 0;
        if (s.charAt(0) == '0') {
            one = 1;
        } else {
            zero = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            int preZero = zero;
            int preOne = one;
            if (s.charAt(i) == '0') {
                one = preZero + 1;
                zero = preOne;
            } else {
                one = preZero;
                zero = preOne + 1;
            }
        }
        return Math.min(zero, one);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("0100"));
    }
}