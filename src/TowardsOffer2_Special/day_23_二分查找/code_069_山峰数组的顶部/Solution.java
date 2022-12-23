package TowardsOffer2_Special.day_23_二分查找.code_069_山峰数组的顶部;

/**
 * completion time = 2022.11.3
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if ((mid == 0 && arr[mid] > arr[mid + 1]) || (mid == arr.length - 1 && arr[mid] > arr[mid - 1])
                    || (mid > 0 && mid < arr.length && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
                ans = mid;
                break;
            } else {
                if (mid == 0) {
                    if (arr[mid] < arr[mid + 1]) {
                        l = mid + 1;
                    }
                } else {
                    if (arr[mid] < arr[mid - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return ans;
    }
}
