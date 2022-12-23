package TowardsOffer2_Special.day_22_前缀树.code_067_最大的异或;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2022.11.2
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> i);
            }
            int temp = (ans << 1) | 1;
            boolean judge = false;
            for (int num : nums) {
                if (seen.contains(temp ^ (num >> i))) {
                    judge = true;
                    break;
                }
            }
            if (judge) {
                ans = temp;
            } else {
                ans = ans << 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 10, 5, 25, 2, 8};
        System.out.println(solution.findMaximumXOR(arr));
    }
}