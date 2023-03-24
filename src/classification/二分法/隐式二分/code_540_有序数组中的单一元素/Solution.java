package classification.二分法.隐式二分.code_540_有序数组中的单一元素;

/**
 * completion time = 2023.3.24
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 如果只有一个数据，直接返回
        if (nums.length == 1){
            return nums[0];
        }
        // 使用二分法
        // index 表示下标
        // 首先考虑头尾两个下标，
        // 1.下标0的时候，只要跟右边相同，就 l = index + 1，否则返回
        // 2.下标为最后一个的时候，只要根左边相同，r = index - 1，否则返回
        // 如果nums[index] != nums[index-1] && 如果nums[index] != nums[index+1]，直接返回
        // 1. index % 2 == 1，如果nums[index] == nums[index-1]，l = index + 1，否则 r = index - 1
        // 2. index % 2 == 0，如果nums[index] == nums[index-1]，r = index - 1，否则 l = index + 1
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    ans = mid;
                    break;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] == nums[mid - 1]) {
                    r = mid - 1;
                } else {
                    ans = mid;
                    break;
                }
            } else {
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    ans = mid;
                    break;
                }
                if (mid % 2 == 1) {
                    if (nums[mid] == nums[mid - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return nums[ans];
    }
}