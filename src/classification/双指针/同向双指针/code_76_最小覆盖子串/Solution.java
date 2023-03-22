package classification.双指针.同向双指针.code_76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * completion time = 2023.3.22
 */
class Solution {
    /**
     * 本题是典型的滑动窗口，因为题目要求返回具体的字符串，所以我们要保证滑动窗口内的子串，除了一开始寻找状态外，都是符合题意的
     * 首先我们需要遍历t的所有字符，记录每个字符出现次数，diff = t.length()
     * 然后遍历s，记录s中每一个字符出现的次数，更新该字符次数后，如果 t中该字符出现的次数 >= s中的某个字符出现次数 ，diff--
     * 当diff == 0，说明该子串是符合题意的，记录为ans，但不一定是最短的，这时候左指针右移，如果s中出现的某一字符数量 < t中出现的某一字符数量，那就diff++
     * 如果减去该字符数量后，仍然 > t中该字符出现的次数，则diff不用变，一直运算，直到diff不为0
     * 遍历完后就直接返回ans
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int diff = t.length();
        String ans = "";
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            // 首先将该字符数 + 1
            count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
            Integer integer = count.get(s.charAt(j));
            if (map.getOrDefault(s.charAt(j), 0) >= integer) {
                diff--;
            }
            while (diff == 0) {
                if (ans.equals("")) {
                    ans = s.substring(i, j + 1);
                } else {
                    ans = ans.length() <= j - i + 1 ? ans : s.substring(i, j + 1);
                }
                count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
                Integer num = count.get(s.charAt(i));
                if(map.getOrDefault(s.charAt(i),0) > num) {
                    diff++;
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}