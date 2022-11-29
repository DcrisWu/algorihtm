package daily.year_2022.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class August_4 {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int index = nums.length - 1;
        int ansSum = 0;
        while (index >= 0 && ansSum <= sum - ansSum) {
            ans.add(nums[index]);
            ansSum += nums[index];
            index--;
        }
        return ans;
    }
}
