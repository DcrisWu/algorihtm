package ByteDance.code_32_最长有效括号;

import java.util.Deque;
import java.util.LinkedList;

/**
 * completion time = 2022.12.10
 */
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        int ans = 0;
        int end = s.length() - 1;
        for (Integer integer : stack) {
            ans = Math.max(end - integer, ans);
            end = integer - 1;
        }
        ans = Math.max(ans, end + 1);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
