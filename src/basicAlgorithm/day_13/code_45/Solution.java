package basicAlgorithm.day_13.code_45;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * completion time = 2022.9.24
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,1,1,4};
        System.out.println(solution.jump(arr));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int[] state = new int[len];
        Arrays.fill(state, Integer.MAX_VALUE / 2);
        state[0] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            int n = Math.min(now + nums[now] + 1, len);
            for (int i = now + 1; i < n; i++) {
                if(state[now]+1 < state[i]){
                    state[i] = Math.min(state[i], state[now] + 1);
                    queue.add(i);
                }
            }
        }
        return state[len - 1];
    }

//    public int dfs(int[] nums, int index) {
//        if (index == nums.length - 1) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE / 2;
//        int last = Math.min(nums.length - 1, nums[index] + index);
//        for (int i = last; i >= index + 1; i--) {
//            min = Math.min(min, dfs(nums, i) + 1);
//        }
//        return min;
//    }
}
