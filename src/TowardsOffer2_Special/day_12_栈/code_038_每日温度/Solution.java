package TowardsOffer2_Special.day_12_栈.code_038_每日温度;

import java.util.Stack;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //stack存储的是数组的下标
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            Integer peek = stack.peek();
            while (temperatures[i] > temperatures[peek]) {
                ans[peek] = i - peek;
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                } else {
                    peek = stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        Solution solution = new Solution();
        System.out.println(solution.dailyTemperatures(arr));
    }
}