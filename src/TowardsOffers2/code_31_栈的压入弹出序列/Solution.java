package TowardsOffers2.code_31_栈的压入弹出序列;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>(pushed.length);
        int j = 0;
        for (int i : pushed) {
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        return stack.isEmpty() && j == popped.length;
    }
}
