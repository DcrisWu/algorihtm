package algorithm.day_11.code_22;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * completion time = 2022.9.23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        List<String> ans = new LinkedList<>();
        dfs(n, "(", 1, 0, set);
        for (String s : set) {
            ans.add(s);
        }
        return ans;
    }

    void dfs(int n, String last, int left, int right, Set<String> ans) {
        if (left < right || left > n) {
            return;
        }
        //如果(还没满
        if (left < n) {
            String now1 = last + "(";
            dfs(n, now1, left + 1, right, ans);
        }
        if(left > right){
            //左边不管有没有满，右边都可以加)
            String now2 = last + ")";
            //如果右边已经满了，就可以加入到ans中
            if (right + 1 == n) {
                ans.add(now2);
            } else {
                dfs(n, now2, left, right + 1, ans);
            }
        }
    }
}
