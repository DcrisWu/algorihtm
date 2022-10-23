package TowardsOffer2.day_06.code_017;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.18
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        String ans = "";
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int diff = t.length();
        //count表示当前子串中，已经有在map中字符的数量
        Map<Character, Integer> count = new HashMap<>();
        //寻找第一个满足条件的字符的下标，标记为l
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), 1);
                l = i;
                diff--;
                break;
            }
        }
        if (diff == 0) {
            ans = s.substring(l, l + 1);
        }
        for (int i = l + 1; i < s.length(); i++) {
            r = i;
            //如果该字符在map中
            if (map.containsKey(s.charAt(i))) {
                //获取当前子串中该字符的数量
                int have = count.getOrDefault(s.charAt(i), 0);
                //将当前遇到的这个字符串加进count中
                count.put(s.charAt(i), have + 1);
                if (have < map.get(s.charAt(i))) {
                    diff--;
                }
            }
            if (diff == 0) {
                if (count.get(s.charAt(l)) > map.get(s.charAt(l))) {
                    for (int j = l; j <= r; j++) {
                        //如果当前字符是t中的字符
                        if (count.containsKey(s.charAt(j))) {
                            //如果子串中该字符的数量 > 需要的数量
                            if (count.get(s.charAt(j)) >= map.get(s.charAt(j))) {
                                l = j;
                                if (count.get(s.charAt(j)) > map.get(s.charAt(j))) {
                                    count.put(s.charAt(j), count.get(s.charAt(j)) - 1);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }

                String aa = s.substring(l, r + 1);
                if (ans.equals("")) {
                    ans = s.substring(l, r + 1);
                } else if (r - l + 1 < ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                diff++;
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l += 1;
                for (int j = l; j <= r; j++) {
                    if (count.containsKey(s.charAt(j))) {
                        l = j;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("a", "a"));
    }
}
