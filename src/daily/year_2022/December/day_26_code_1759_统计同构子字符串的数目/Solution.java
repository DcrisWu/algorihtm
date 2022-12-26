package daily.year_2022.December.day_26_code_1759_统计同构子字符串的数目;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countHomogenous(String s) {
        long mod = (long) (1e9 + 7);
        int begin = 0;
        long ans = 0L;
        while (begin < s.length()) {
            int end = begin;
            char c = s.charAt(begin);
            while (end < s.length() && s.charAt(end) == c) {
                end++;
            }
            ans = (ans + ((long) (1 + (end - begin)) * (end - begin)) / 2) % mod;
            begin = end;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHomogenous("abbcccaa"));
    }
}
