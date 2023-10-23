package ByteDance.code_32_最长有效括号;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * completion time = 2023.10.23
 */
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        // 如果组成有效括号，就不会存在这部分的下标，我们只需找出缺失的连续下标
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else{
                if (stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    ans = Math.max(ans, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
