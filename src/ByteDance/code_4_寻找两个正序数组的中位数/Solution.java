package ByteDance.code_4_寻找两个正序数组的中位数;

class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return getKthElement(nums1, nums2, total / 2 + 1);
        } else {
            double left = getKthElement(nums1, nums2, total / 2);
            double right = getKthElement(nums1, nums2, total / 2 + 1);
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

}