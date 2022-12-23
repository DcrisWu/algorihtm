package TowardsOffer2_Special.day_23_二分查找.code_070_排序数组中只出现一次的数字;

/**
 * completion time = 2022.11.3
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if ((mid == 0 && nums[mid] != nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) || (mid > 0 && mid < nums.length - 1 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) {
                ans = nums[mid];
                break;
            }
            if (mid % 2 == 0) {
                if (mid != nums.length - 1) {
                    if (nums[mid] == nums[mid + 1]) {
                        l = mid + 2;
                    } else {
                        r = mid;
                    }
                } else {
                    r = mid - 2;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,4,4,8,8,2};
        Solution solution = new Solution();
        solution.singleNonDuplicate(arr);
    }
}