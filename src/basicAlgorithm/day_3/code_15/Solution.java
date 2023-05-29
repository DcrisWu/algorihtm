package basicAlgorithm.day_3.code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.9.16
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3){
            return ans;
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            //每个元素的所有组合在第一次遍历到的时候，就会被添加到ans中，下次再遇到这个元素，直接跳过就好了
            if ((i > 0) && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> part = new ArrayList<>();
                    part.add(nums[i]);
                    part.add(nums[l]);
                    part.add(nums[r]);
                    ans.add(part);
                    //对于nums[i]来说，nums[l]元素已经使用过，跳转到下一个与nums[l]不同的元素的下标
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //对于nums[i]来说，nums[r]元素已经使用过，跳转到下一个与nums[r]不同的元素的下标
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
