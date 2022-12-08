package ByteDance.code_3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.12.8
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - begin + 1);
                map.put(s.charAt(i), i);
            } else {
                begin = Math.max(begin, map.get(s.charAt(i)) + 1);
                ans = Math.max(ans, i - begin + 1);
                map.put(s.charAt(i), i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}
