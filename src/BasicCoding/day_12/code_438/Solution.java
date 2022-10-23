package BasicCoding.day_12.code_438;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time 2022.10.8
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] p_mark = new int[26];
        for (int i = 0; i < p.length(); i++) {
            p_mark[p.charAt(i) - 'a'] += 1;
        }
        List<Integer> ans = new LinkedList<>();
        int[] count = new int[26];
        for (int i = 0; i <= s.length() - p.length(); i++) {
            for (int j = i; j < i + p.length(); j++) {
                count[s.charAt(j) - 'a'] += 1;
            }
            if (Arrays.equals(p_mark, count)) {
                ans.add(i);
            }
            Arrays.fill(count,0);
        }
        return ans;
    }
}
