package competition.leetcode_weekly.No_367_day_2023_10_15.code_100084_最短且字典序最小的美丽子字符串;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.15
 */
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] idx = new int[]{0, Integer.MAX_VALUE};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                st.addLast(i);
                while (st.size() >= k) {
                    if (i - st.peekFirst() < (idx[1] - idx[0]) || (i - st.peekFirst() == (idx[1] - idx[0]) && s.substring(idx[0], idx[1] + 1).compareTo(s.substring(st.peekFirst(), i + 1)) > 0)) {
                        idx[0] = st.peekFirst();
                        idx[1] = i;
                    }
                    st.pollFirst();
                }
            }
        }
        return idx[1] == Integer.MAX_VALUE ? "" : s.substring(idx[0], idx[1] + 1);
    }

    public static void main(String[] args) {
        String s = "1100100101011001001";
        int k = 7;
        System.out.println(new Solution().shortestBeautifulSubstring(s, k));
    }
}
