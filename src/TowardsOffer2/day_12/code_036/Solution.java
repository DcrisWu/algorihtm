package TowardsOffer2.day_12.code_036;

import java.util.Objects;
import java.util.Stack;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!Objects.equals(token, "+") && !Objects.equals(token, "-") && !Objects.equals(token, "*") && !Objects.equals(token, "/")) {
                stack.add(Integer.parseInt(token));
            } else {
                Integer second = stack.pop();
                Integer first = stack.pop();
                switch (token) {
                    case "+" -> stack.push(first + second);
                    case "-" -> stack.push(first - second);
                    case "*" -> stack.push(first * second);
                    default -> stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
}