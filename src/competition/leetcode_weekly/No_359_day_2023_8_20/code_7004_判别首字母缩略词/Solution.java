package competition.leetcode_weekly.No_359_day_2023_8_20.code_7004_判别首字母缩略词;

import java.util.List;

/**
 * completion time = 2023.8.20
 */
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}