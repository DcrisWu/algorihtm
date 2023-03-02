package competition.day_2023_2_26.code_6368_找出字符串的可整除数组;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        Long num = 0L;
        for (int i = 0; i < word.length(); i++) {
            num = num * 10 + (word.charAt(i) - '0');
            if (num % m == 0) {
                ans[i] = 1;
                num = 0L;
            } else {
                num %= m;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.divisibilityArray("1010", 10);
    }
}
