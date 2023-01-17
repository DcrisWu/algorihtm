package daily.year_2023.January.day_15_code_2293_极大极小游戏;

class Solution {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sub = new int[nums.length / 2];
        for (int i = 0; i < sub.length; i++) {
            if (i % 2 == 0){
                sub[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
            }else {
                sub[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
            }
        }
        return minMaxGame(sub);
    }

}
