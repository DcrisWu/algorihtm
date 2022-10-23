package BinarySearch;

/**
 * code_154
 */
public class thirteen_1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            //第一种情况，中间值 < 右值，说明最小值 <= 中间值，所以r = mid
            if(nums[mid] < nums[r]){
                r = mid;
            }
            //第二种情况，中间值 > 右值，说明中间值右边 <= 中间值，所以l = mid + 1
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            //第三种情况，中间值 == 右值，犹豫存在重复元素，无法确定最小值在左边还是在右边，
            //但是我们知道，它们的值相同，所以无论nums[r]是不是最小值，它都有一个替代品nums[mid]
            //因此我们可以忽略二分查找区间的右断点
            //也就是说，无论nums[r]是不是最小值，我们都可以不考虑r,然后r =- 1，因为就算原来nums[r]为最小值，我们都有nums[mid]可以找出来
            //当nums[mid] == nums[r]时，一个一个缩小范围
            else {
                r--;
            }
        }
        return nums[l];
    }
}
