package competition.No_334_day_2023_2_26.code_6369_左右元素和的差值;

class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 0;
        rightSum[rightSum.length - 1] = 0;
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = rightSum.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}
