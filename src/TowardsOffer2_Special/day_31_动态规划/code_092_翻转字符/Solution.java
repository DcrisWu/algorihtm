package TowardsOffer2_Special.day_31_动态规划.code_092_翻转字符;

/**
 * completion time = 2022.11.10
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        int preZero = 0;
        int preOne = 0;
        // 初始化第一位
        if (s.charAt(0) == '0') {
            preOne = 1;
        } else {
            preZero = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            int nowZero = 0;
            int nowOne = 0;
            if (s.charAt(i) == '1') {
                nowOne = Math.min(preZero, preOne);
                nowZero = preZero + 1;
            } else {
                nowOne = preOne + 1;
                nowZero = preZero;
            }
            preOne = nowOne;
            preZero = nowZero;
        }
        return Math.min(preZero, preOne);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr("00110"));
    }
}
