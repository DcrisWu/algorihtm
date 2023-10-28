package meeting.tplink;

public class Solution {

    public boolean judge(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else {
                break;
            }
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().judge(nums));
    }
}
