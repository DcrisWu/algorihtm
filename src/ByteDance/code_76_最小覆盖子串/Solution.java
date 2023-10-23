package ByteDance.code_76_最小覆盖子串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.8.18
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> cnt = new HashMap<>();
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                q.addLast(i);
                if (cnt.get(c) <= map.get(c)) {
                    count++;
                }
                while (count == t.length()) {
                    if (ans.equals("")) {
                        ans = s.substring(q.peekFirst(), i + 1);
                    } else {
                        if (i - q.peekFirst() + 1 < ans.length()) {
                            ans = s.substring(q.peekFirst(), i + 1);
                        }
                    }
                    Integer first = q.pollFirst();
                    cnt.put(s.charAt(first), cnt.get(s.charAt(first)) - 1);
                    if (cnt.get(s.charAt(first)) < map.get(s.charAt(first))) {
                        count--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
