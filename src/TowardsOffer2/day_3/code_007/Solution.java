package TowardsOffer2.day_3.code_007;

import java.util.*;

/**
 * completion time = 2022.10.17
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[l]);
                    tuple.add(nums[r]);
                    ans.add(tuple);
                    while (l+1 < nums.length && nums[l] == nums[l+1]){
                        l++;
                    }
                    while (r - 1 >= 0 &&nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}