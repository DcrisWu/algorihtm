package competition.leetcode_weekly.No_348_day_2023_6_4.code_2716_最小化字符串长度;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2023.6.8
 */
class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
