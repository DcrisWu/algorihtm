package algorithm.day_12.code_55;

import java.util.Arrays;

/**
 * completion time = 2022.9.24
 */
public class Solution {

    public static void main(String[] args) {
        boolean[] arr = new boolean[5];
        Arrays.fill(arr, 0, 2, true);
        for (boolean b : arr) {
            System.out.println(b);
        }
    }

    public boolean canJump(int[] nums) {
        if(nums[0] == 0){
            return false;
        }
        int n = nums.length;
        boolean[] state = new boolean[n];
        state[0] = true;
        for (int i = 0; i < n - 1; i++) {
            if (state[i]) {
                int last = Math.min(n, i + nums[i] + 1);
                Arrays.fill(state, i + 1, last, true);
            }
            if (state[n-1]){
                return true;
            }
        }
        return false;
    }
}
