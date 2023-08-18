package ByteDance.code_76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.8.18
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int diff = t.length();
        Map<Character, Integer> smap = new HashMap<>();
        int i = 0;
        String ans = "";
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            if (smap.get(c) <= tmap.getOrDefault(c, 0)) {
                diff--;
            }
            while (diff == 0) {
                char f = s.charAt(i);
                if (ans.equals("")) {
                    ans = s.substring(i, j + 1);
                } else if (j - i + 1 < ans.length()) {
                    ans = s.substring(i, j + 1);
                }
                smap.put(f, smap.get(f) - 1);
                Integer num = smap.get(f);
                if (tmap.getOrDefault(f, 0) > num) {
                    diff++;
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
