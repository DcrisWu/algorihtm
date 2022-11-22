package TowardsOffer.day_3_字符串.code_05_替换空格;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.22
 */
class Solution {
    public String replaceSpace(String s) {
        List<Integer> blank = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                blank.add(i);
            }
        }
        int pre = 0;
        StringBuilder sb = new StringBuilder("");
        for (Integer integer : blank) {
            sb.append(s.substring(pre, integer));
            sb.append("%20");
            pre = integer + 1;
        }
        sb.append(s.substring(pre));
        return sb.toString();
    }
}
