package basicAlgorithm.day_14.code_5;

/**
 * completion time = 2022.9.25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
//        int left = 0, right = 0;
        int minLeft = 0, maxRight = 0;
        int maxLen = 1;
        boolean[][] state = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || state[l + 1][r - 1])) {
                    state[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        minLeft = l;
                        maxRight = r;
                    }
                }
            }
        }
        return s.substring(minLeft, maxRight + 1);
    }
}
