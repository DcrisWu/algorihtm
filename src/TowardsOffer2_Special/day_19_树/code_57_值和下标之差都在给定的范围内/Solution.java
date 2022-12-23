package TowardsOffer2_Special.day_19_树.code_57_值和下标之差都在给定的范围内;

import java.util.TreeSet;

/**
 * completion time = 2022.10.30
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling( (long)nums[i] - (long)t);
            if (ceiling != null && ceiling <= (long)nums[i] + (long)t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 3, 4, 5};
        System.out.println(solution.containsNearbyAlmostDuplicate(arr, 3, 0));
    }
}