package TowardsOffer.day_5_查找算法_中等.code_11_旋转数组的最小数字;

/**
 * completion time = 2022.11.24
 */
class Solution {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 3};
//        int[] arr = {3, 1, 3};
        int[] arr = {10, 1, 10, 10, 10};
        Solution solution = new Solution();
        System.out.println(solution.minArray(arr));
    }

    // 难点在于，数组旋转了，而且有重复元素
    // 当numbers[pivot]的值等于numbers[high]时，不能直接判断出往左还是往右，只能保守得将high设为pivot
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = (low + high) >> 1;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
