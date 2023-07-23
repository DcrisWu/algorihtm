package competition.leetcode_weekly.No_355_day_2023_7_23.code_6921_按分隔符拆分字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.23
 */
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != separator) {
                    temp.append(word.charAt(i));
                } else {
                    if (!temp.isEmpty()){
                        res.add(temp.toString());
                        temp = new StringBuilder();
                    }
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp.toString());
            }
        }
        return res;
    }
}