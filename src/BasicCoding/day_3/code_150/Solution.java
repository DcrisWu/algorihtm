package BasicCoding.day_3.code_150;

import java.util.Stack;

/**
 * completion time = 2022.10.2
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.add(Integer.parseInt(token));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if (token.equals("+")) {
                    int ans = first + second;
                    stack.add(ans);
                } else if (token.equals("-")) {
                    int ans = first - second;
                    stack.add(ans);
                } else if (token.equals("*")) {
                    int ans = first * second;
                    stack.add(ans);
                }else {
                    int ans = first / second;
                    stack.add(ans);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(arr));
    }
}
