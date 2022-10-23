package algorithm.day_5.code_438;

import java.util.*;

/**
 * completion time = 2022.9.17
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int p_len = p.length();
        int s_len = s.length();
        int[] pCount = new int[26];
        int[] mark = new int[26];
        for (int i = 0; i < p_len; i++) {
            pCount[p.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i <= s_len - p_len; i++) {
            for (int j = i; j < i + p_len; j++) {
                mark[s.charAt(j) - 'a'] += 1;
            }
            if (Arrays.equals(mark, pCount)) {
                ans.add(i);
            }
            Arrays.fill(mark,0);
        }
        return ans;

    }
}
