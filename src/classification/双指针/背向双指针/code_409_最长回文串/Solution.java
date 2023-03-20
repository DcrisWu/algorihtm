package classification.双指针.背向双指针.code_409_最长回文串;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.3.20
 */
class Solution {
    /**
     * 如果都是偶数，那么偶数相加就行
     * 如果存在奇数，就取奇数-1，返回的时候再+1
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean hasOdd = false;
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                ans += entry.getValue();
            } else {
                hasOdd = true;
                ans += entry.getValue() - 1;
            }
        }
        return hasOdd ? ans + 1 : ans;
    }
}