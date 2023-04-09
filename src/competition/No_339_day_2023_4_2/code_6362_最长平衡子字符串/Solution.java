package competition.No_339_day_2023_4_2.code_6362_最长平衡子字符串;

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length();) {
            int zeros = 0, ones = 0;
            for (int j = i; j < s.length(); i++,j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    break;
                }
            }
            for (int j = i; j < s.length(); i++,j++) {
                if (s.charAt(j) == '1') {
                    ones++;
                    count = Math.max(count,Math.min(zeros, ones));
                } else {
                    break;
                }
            }
        }
        return count*2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestBalancedSubstring("01000111"));
    }
}