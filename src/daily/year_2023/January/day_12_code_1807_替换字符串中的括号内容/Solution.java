package daily.year_2023.January.day_12_code_1807_替换字符串中的括号内容;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder ans = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            int begin = index;
            while (index < s.length() && s.charAt(index) != '(') {
                index++;
            }
            ans.append(s, begin, index);
            begin = ++index;
            if (begin >= s.length()) {
                break;
            }
            while (index < s.length() && s.charAt(index) != ')') {
                index++;
            }
            ans.append(map.getOrDefault(s.substring(begin, index), "?"));
            index++;
        }
        return ans.toString();
    }
}
