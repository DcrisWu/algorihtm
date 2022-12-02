package TowardsOffer.day_10_动态规划_中等.code_46_把数字翻译成字符串;

/**
 * completion time = 2022.12.1
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.translateNum(25);
    }
    public int translateNum(int num) {
        char[] array = String.valueOf(num).toCharArray();
        if (array.length == 1) {
            return 1;
        }
        int first = 1;
        int second = 0;
        if ((array[0] == '1') || (array[0] == '2' && array[1] < '6')) {
            second = 2;
        } else {
            second = 1;
        }
        int ans = second;
        for (int i = 2; i < array.length; i++) {
            if ((array[i - 1] == '1') || (array[i - 1] == '2' && array[i] < '6')) {
                ans = first + second;
            }
            first = second;
            second = ans;
        }
        return ans;
    }
}
