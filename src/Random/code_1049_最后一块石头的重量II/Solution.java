package Random.code_1049_最后一块石头的重量II;

import java.util.Arrays;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        // 0-1背包问题中，数组下标表示的是物品的价值
        // 这里是一个一个遍历，0-1背包问题因为只能使用一次，所以数组从左到右遍历，遇到的每一个数都是第一次遇见的
        // dp[0]表示物品价值为0的时候，总是存在的，所以一定为true，所以dp[num] = dp[num - num] = dp[0]
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
        }
        int neg = 0;
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                neg = i;
                break;
            }
        }
        return sum - neg * 2;
    }
}
