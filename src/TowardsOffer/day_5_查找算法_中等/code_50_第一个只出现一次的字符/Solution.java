package TowardsOffer.day_5_查找算法_中等.code_50_第一个只出现一次的字符;

import java.util.LinkedHashSet;

/**
 * completion time = 2022.11.25
 */
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] ch = new int[26];
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (ch[s.charAt(i) - 'a'] == 0) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
            }
            ch[s.charAt(i) - 'a'] += 1;
        }
        for (Character character : set) {
            return character;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leecode"));
    }
}
