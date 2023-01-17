package daily.year_2023.January.day_13_code_2287_重排字符形成目标字符串;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            count.put(target.charAt(i), count.getOrDefault(target.charAt(i), 0) + 1);
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                arr[s.charAt(i) - 'a'] += 1;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Character character : count.keySet()) {
            ans = Math.min(arr[character - 'a'] / count.get(character), ans);
        }
        return ans;
    }
}
