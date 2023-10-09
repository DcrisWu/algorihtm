package competition.leetcode_weekly.No_364_day_2023_9_24.code_8048_最大二进制奇数;

class Solution {
    // 第一题
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        sb.append("1".repeat(Math.max(0, count - 1)));
        sb.append("0".repeat(Math.max(0, s.length()-count)));
        sb.append("1");
        return sb.toString();

    }
}