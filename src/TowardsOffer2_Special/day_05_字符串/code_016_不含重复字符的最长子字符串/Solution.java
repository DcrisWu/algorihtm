package TowardsOffer2_Special.day_05_字符串.code_016_不含重复字符的最长子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.18
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int ans = 0;
        int l = 0, r = -1;
        for (int i = 0; i < s.length(); i++) {
            r = i;
            //如果当前字符出现过，那就记录此前的最大长度
            if (count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) >= l) {
                //如果有相同的字符出现了，那就记录当前不重复字符的字符串的最大长度，取最大值
                ans = Math.max(ans, r - l);
                l = count.get(s.charAt(i)) + 1;
            }
            count.put(s.charAt(i), i);
        }
        ans = Math.max(ans, r - l + 1);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkewdf"));
    }
}