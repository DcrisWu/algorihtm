package ByteDance.code_32_最长有效括号;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * completion time = 2022.12.10
 */
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // 如果组成有效括号，就不会存在这部分的下标，我们只需找出缺失的连续下标
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 1 && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        int end = s.length() - 1;
        int ans = 0;
        for (Integer i : stack) {
            ans = Math.max(end - i, ans);
            end = i - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
