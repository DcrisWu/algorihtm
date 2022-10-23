package TowardsOffer2.day_05.code_015;

import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.10.18
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new LinkedList<Integer>();
        }
        int[] mark = new int[26];
        int[] now = new int[26];
        for (int i = 0; i < p.length(); i++) {
            mark[p.charAt(i) - 'a']++;
            now[s.charAt(i) - 'a']++;
        }
        List<Integer> ans = new LinkedList<>();
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(mark[i] - now[i]);
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            char pop = s.charAt(i - p.length());
            char push = s.charAt(i);
            if (pop == push && diff == 0) {
                ans.add(i - p.length() + 1);
            } else {
                // 如果被弹出的字符在now的数量 > mark中该字符的数量，diff就会减少
                if (now[pop - 'a'] > mark[pop - 'a']) {
                    diff--;
                } else {
                    //如果被弹出的字符在now的数量 <= mark中该字符的数量，diff就会增加
                    diff++;
                }
                now[pop - 'a']--;
                //如果假如的字符在now中的数量 >= mark中该字符的数量，diff就会增加
                if (now[push - 'a'] >= mark[push - 'a']) {
                    diff++;
                } else {
                    diff--;
                }
                now[push - 'a']++;
                if (diff == 0) {
                    ans.add(i - p.length() + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
