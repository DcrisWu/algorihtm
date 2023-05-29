package basicAlgorithm.day_1.code_34;

/**
 * completion time = 2022.9.15
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {};
        System.out.println(solution.searchRange(arr, 6));
    }
    public int[] searchRange(int[] nums, int target) {
        int begin = -1, end = -1;
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                if(nums[mid] == target){
                    begin = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = begin != -1 ? begin : 0;
        r = n-1;
        while (l<=r){
            int mid = (l+r)>>1;
            if(nums[mid] <= target){
                if(nums[mid] == target){
                    end = mid;
                }
                l = mid +1;
            }else {
                r = mid - 1;
            }
        }
        return new int[]{begin,end};
    }
}
