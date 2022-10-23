package BasicCoding.day_10.code_503;

import java.util.Arrays;
import java.util.Stack;

/**
 * completion time = 2022.10.7
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.empty()) {
                int peek = stack.peek();
                if (nums[i] > nums[peek]) {
                    ans[peek] = nums[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.add(i);
        }
        for (int num : nums) {
            if (stack.isEmpty()) {
                break;
            }
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (num > nums[peek]) {
                    ans[peek] = num;
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
