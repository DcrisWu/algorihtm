package basicAlgorithm.day_16.code_673;

import java.awt.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5,4,7,2};
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(arr));
    }
    public int findNumberOfLIS(int[] nums) {
        //x表示最长子串的长度，y表示到达这一长度的子串有y个
        Point[] dp = new Point[nums.length];
        for (int i = 0;i<nums.length;i++){
            dp[i] = new Point(1,1);
        }
        int mark = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j].x + 1 > dp[i].x) {
                        dp[i].x = dp[j].x + 1;
                        dp[i].y = dp[j].y;
                        mark = Math.max(dp[i].x,mark);
                    } else if (dp[j].x + 1 == dp[i].x) {
                        dp[i].y += dp[j].y;
                    }
                }
            }
        }
        int count = 0;
        for (int i = nums.length-1;i>=0;i--){
            if(dp[i].x == mark){
                count += dp[i].y;
            }
        }
        return count;

    }
}
