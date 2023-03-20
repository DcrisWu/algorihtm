package classification.双指针.相向双指针.code_167_两数之和II_输入有序数组;

/**
 * completion time = 2023.3.20
 */
class Solution {
    /**
     * 双指针的基本原理是：缩减搜索空间
     * 在这道题中，就需要选择 i, j的初始位置，如何才能最好的缩减搜索空间
     * 假设 numbers[i]+numbers[j] == target, 0 <= i < j < numbers.length
     * 初始下标 left = 0, right = numbers.length-1，(left <= i && right >= j恒成立)
     * 在这种情况下，除非是left == i和right == j，不然一定会存在left先到i || right先到j
     * 假如 left 和 right 都还没到 i 和 j，那么 i 和 j 都可以移动
     * {
     *     if(sum < target){
     *         left右移
     *     }
     *     if(sum > target){
     *         right左移
     *     }
     * }
     * 假如 right先到j，那么sum < target，就只能够i往右移
     * 假如 left 先到i，那么sum > target，就只能j向左移
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
