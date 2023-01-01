package daily.year_2023.January.day_1_code_2351_第一个出现两次的字母;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return s.charAt(i);
            } else {
                set.add(s.charAt(i));
            }
        }
        return ' ';
    }
}