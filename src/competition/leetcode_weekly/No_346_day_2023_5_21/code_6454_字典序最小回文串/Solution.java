package competition.leetcode_weekly.No_346_day_2023_5_21.code_6454_字典序最小回文串;

/**
 * completion time = 2023.5.21
 */
class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder reverse = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (lc == rc) {
                l++;
                r--;
                continue;
            }
            if (lc < rc) {
                reverse.setCharAt(r, lc);
            } else {
                reverse.setCharAt(l, rc);
            }
            l++;
            r--;
        }
        return reverse.toString();
    }
}