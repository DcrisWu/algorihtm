package Random.code_674_最长连续递增序列;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                ans = Math.max(ans, i - left + 1);
            }else {
                left = i;
            }
        }
        return ans;
    }
}