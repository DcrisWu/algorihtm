package BasicCoding.day_6.code_739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            int pre = stack.peek();
            while (temperatures[i] > temperatures[pre]) {
                ans[pre] = i - pre;
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                pre = stack.peek();
            }
            stack.add(i);
        }
        for (Integer integer : stack) {
            ans[integer] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(solution.dailyTemperatures(arr));
    }
}
