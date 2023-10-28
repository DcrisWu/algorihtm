package ByteDance.code_4_寻找两个正序数组的中位数;

/**
 * completion time = 2023.10.28
 */
class Solution {
    public static void main(String[] args) {
        int[] arr2 = {0, 0};
        int[] arr1 = {0, 0};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
//        if (total % 2 == 1) {
//            return getKthElement(nums1, nums2, total / 2 + 1);
//        } else {
//            double left = getKthElement(nums1, nums2, total / 2);
//            double right = getKthElement(nums1, nums2, total / 2 + 1);
//            return (left + right) / 2;
//        }
        if (total % 2 == 1) {
            return getKthElement2(nums1, nums2, total / 2 + 1);
        } else {
            double left = getKthElement2(nums1, nums2, total / 2);
            double right = getKthElement2(nums1, nums2, total / 2 + 1);
            return (left + right) / 2;
        }
    }

    // k是偶数
    int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况下
            //[index,newIndex]都是没遍历过的数据
            int half = k / 2;
            int newIndex1 = Math.min(m, index1 + half) - 1;
            int newIndex2 = Math.min(n, index2 + half) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    int getKthElement2(int[] nums1, int[] nums2, int k) {
        // 如果能在nums1中找到，就直接返回
        // 招不到就是在nums2中，因为都是排好序的，所以直接索引运算就可以了
        int l = 0, r = nums1.length - 1;
        int idx1 = -1, idx2 = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt2 = numsLessThan(nums2, nums1[mid]);
            if (cnt2 + mid + 1 <= k) {
                idx1 = mid;
                idx2 = cnt2 - 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 第 k 个在 nums1
        if (idx1 + idx2 + 2 == k) {
            return nums1[idx1];
        }
        // 否则第 k 个在 nums2，而且一定是 >= idx2
        // 在nums1中，<=nums1[idx1] < k个，<=nums1[idx+1] > k个
        // 那么前 k 个数中，nums1一定占有 idx1 + 1个
        // 那么第 k个数在 idx2 = k - (idx1 + 1) - 1 中
        return nums2[k - idx1 - 2];
    }

    // <= target 的数量
    int numsLessThan(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }
}