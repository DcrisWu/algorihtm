package algorithm.day_1.code_33;

/**
 * completion time = 2022.9.15
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,5,6,7,0,1,2};
        solution.search(arr,1);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (target <= nums[r]) {
            int temp_l = 0;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    temp_l = mid;
                }
            }
            l = temp_l;
            r = n - 1;
        } else {
            int temp_r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if(nums[mid] > nums[n-1]){
                    temp_r = mid;
                    l = mid+1;
                }else {
                    r = mid - 1;
                }
            }
            l = 0;
            r = temp_r;
        }
        int ans = -1;
        while (l<=r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                l = mid+1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
