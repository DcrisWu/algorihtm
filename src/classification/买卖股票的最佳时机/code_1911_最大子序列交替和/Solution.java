package classification.买卖股票的最佳时机.code_1911_最大子序列交替和;

/**
 * completion time = 2023.7.27
 */
class Solution {
    public long maxAlternatingSum(int[] nums) {
        // add表示最后一个操作是加,sub表示最后一个操作是减
        // 第一个数只可以加，不可以减
        long add = nums[0];
        long sub = 0;
        // add[i] = max(add[i-1],sub[i-1]+nums[i])
        // sub[i] = max(sub[i-1],add[i-1]-nums[i])
        for (int i = 1; i < nums.length; i++) {
            // 如果是第一次加，那么刚好sub = 0,不影响结果
            long temp = Math.max(add, sub + nums[i]);
            sub = Math.max(sub, add - nums[i]);
            add = temp;
        }
        return Math.max(add, sub);
    }
}
