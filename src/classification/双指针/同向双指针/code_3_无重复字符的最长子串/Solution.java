package classification.双指针.同向双指针.code_3_无重复字符的最长子串;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * completion time  = 2023.3.22
 */
class Solution {
    /**
     * 本题的思路是维护滑动窗口，用Set或者Map维护一个出现过的字符的集合，当遇到重复集合时候，滑动左窗口，直到上一个出现过的字符被排除在滑动窗口外
     * 可以使用Set或者Map来维护
     */
    public int lengthOfLongestSubstring(String s) {
        /*int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            ans = Math.max(ans, j - i + 1);
        }
        return ans;*/

        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}