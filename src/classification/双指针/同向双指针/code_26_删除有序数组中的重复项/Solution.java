package classification.双指针.同向双指针.code_26_删除有序数组中的重复项;

class Solution {
    /**
     * 因为题目给的数据都已经是排好序的，所以只需要直接遍历即可
     * 题目要求删除重复的项，那就使用双指针 i 和 j
     * j 表示第一次出现nums[j]时候的下标，nums[i]存储的是nums[j]，然后i++
     * 因为i只有遇到不一样的，才会右移，而j不管遇到是否相同的数都会右移，所以j >= i
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            nums[i++] = nums[j];
        }
        return i;
    }
}
