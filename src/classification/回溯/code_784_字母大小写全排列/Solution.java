package classification.回溯.code_784_字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.9.8
 */
class Solution {

    private String s;
    private List<String> res;

    public List<String> letterCasePermutation(String s) {
        this.s = s;
        res = new ArrayList<>();
        recursive(new StringBuilder(), 0);
        return res;
    }

    void recursive(StringBuilder pre, int idx) {
        if (idx == s.length()) {
            res.add(pre.toString());
            return;
        }
        char c = s.charAt(idx);
        if (Character.isLetter(c)) {
            char low = Character.toLowerCase(c);
            pre.append(low);
            recursive(pre, idx + 1);
            pre.delete(pre.length() - 1, pre.length());
            char up = Character.toUpperCase(c);
            pre.append(up);
        } else {
            pre.append(c);
        }
        recursive(pre, idx + 1);
        pre.delete(pre.length() - 1, pre.length());
    }
}
