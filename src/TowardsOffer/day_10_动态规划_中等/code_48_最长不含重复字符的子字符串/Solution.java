package TowardsOffer.day_10_动态规划_中等.code_48_最长不含重复字符的子字符串;

import java.util.*;

/**
 * completion time = 2022.12.1
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int ans = 0;
        Set<Character> move = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                for (Character character : set) {
                    if (character != s.charAt(i)) {
                        move.add(character);
                    } else {
                        move.add(character);
                        break;
                    }
                }
            }
            set.removeAll(move);
            move.clear();
            set.add(s.charAt(i));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
}
