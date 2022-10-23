package BinarySearch;

/**
 * code_287
 */
public class five_1 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1,right = n;
        int ans = 0;
        while (left <= right){
            int mid = (left+ right)>>1;
            int cnt = 0;
            for(int i = 0;i<n;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                left = mid+1;
            }else {
                right = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}
