package TowardsOffer2.day_4_数组.code_012_左右两边子数组的和相等;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = preSum[i] - preSum[0];
            int right = preSum[nums.length] - preSum[i + 1];
            if(left == right){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, -1, 2};
        System.out.println(solution.pivotIndex(arr));

    }
}