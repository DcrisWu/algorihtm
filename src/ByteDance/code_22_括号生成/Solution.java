package ByteDance.code_22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.10.28
 */
class Solution {
    private int n;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new ArrayList<>();
        dfs(0, 0, new StringBuilder());
        return res;
    }

    void dfs(int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
        }
        if (left < n) {
            sb.append('(');
            dfs(left + 1, right, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (right < left) {
            sb.append(')');
            dfs(left, right + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

}