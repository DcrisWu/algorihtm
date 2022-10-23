package TowardsOffer2.day_06.code_020;

class Solution {
    public int countSubstrings(String s) {
        /*int count = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i != s.length() - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    count++;
                }
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[j][i] = dp[j + 1][i - 1] && (s.charAt(i) == s.charAt(j));
                if (dp[j][i]) {
                    count++;
                }
            }
        }
        return count;*/

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //当回文串是奇数时
            int l = i, r = i;
            while ((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))) {
                count++;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while ((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aaa"));

    }
}
