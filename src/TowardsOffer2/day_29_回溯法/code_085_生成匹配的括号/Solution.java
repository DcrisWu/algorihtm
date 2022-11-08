package TowardsOffer2.day_29_回溯法.code_085_生成匹配的括号;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        backTrack(ans, sb, n, n);
        return ans;
    }

    void backTrack(List<String> ans, StringBuilder sb, int left, int right) {
        if (left == right && left == 0) {
            ans.add(new String(sb));
            return;
        }
        if (left == right) {
            sb.append('(');
            backTrack(ans, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                sb.append('(');
                backTrack(ans, sb, left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            backTrack(ans, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
