package classification.回溯.code_22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.20
 */
class Solution {

    private List<String> res;
    private int max;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        max = n;
        recursive(0, 0, new StringBuilder());
        return res;
    }

    // left, right 表示已经有的左括号和右括号的数量
    void recursive(int left, int right, StringBuilder sb) {
        if (left == max && right == max) {
            res.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append('(');
            recursive(left + 1, right, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (right < left) {
            sb.append(')');
            recursive(left, right + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
