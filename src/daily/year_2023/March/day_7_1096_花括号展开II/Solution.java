package daily.year_2023.March.day_7_1096_花括号展开II;

import java.util.*;

/**
 * completion time = 2023.3.7
 */
class Solution {
    // 返回的结果要有顺序，所以不能用HashSet，用TreeSet来排序
    private Set<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    void dfs(String expr) {
        int j = expr.indexOf('}');
        if (j == -1) {
            // 没有{}就绝对没有,
            // 这样形式才可以加进Set
            set.add(expr);
            return;
        }
        int i = j;
        while (i >= 0 && expr.charAt(i) != '{') {
            i--;
        }
        String a = expr.substring(0, i);
        String c = expr.substring(j + 1);
        // 先去掉括号
        String substring = expr.substring(i + 1, j);
        // 再把去掉括号后的,去掉，留下的只有abc | {ab,cd}
        // 然后不断递归
        for (String b : substring.split(",")) {
            dfs(a + b + c);
        }
    }
}
