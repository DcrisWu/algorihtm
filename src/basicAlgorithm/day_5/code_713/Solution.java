package basicAlgorithm.day_5.code_713;

/**
 * completion time = 2022.9.17
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int product = 1;
        int i = 0, count = 0;
        int n = nums.length;
        //固定右端点j，遍历[i,j]，寻找满足条件的最小i值，j-i+1就是固定了右端点后，符合要求的子数组的数量
        for (int j = 0; j < n; j++) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}
