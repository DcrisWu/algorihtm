package competition.leetcode_weekly.No_354_day_2023_7_16.code_6924_最长合法子字符串的长度;

import java.util.*;

/**
 * completion time = 2023.7.16
 *
 * 有点难，但其实难点只是确认一个左边界，然后遍历 o(1)个子串，看是否存在不合法的子串
 */
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        Set<String> set = new HashSet<>(forbidden);
        int ans = 0, l = 0;
        for (int r = 0; r < n; r++) {
            // 左边界最小值
            int min = r - 9;
            // 以 word[r]结尾的长度为 1 - 10 的子串，是否都是合法的
            for (int i = r; i >= min && i >= l; i--) {
                String sub = word.substring(i, r + 1);
                // 如果 word.sub(i,r+1) 已经是不合法的，没必要再往前遍历了
                // 下一个合法的子串，一定是从 i+1 开始的
                if (set.contains(sub)) {
                    l = i + 1;
                    break;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "aaaabaaacc";
        List<String> forbidden = new ArrayList<>();
        forbidden.add("bcca");
        forbidden.add("aaa");
        forbidden.add("aabaa");
        forbidden.add("baaac");
        System.out.println(solution.longestValidSubstring(word, forbidden));
    }
}