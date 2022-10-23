package BasicCoding.day_3.code_66;

import java.util.Arrays;

/**
 * completion time = 2022.10.2
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int sum = (digits[digits.length - 1] + 1) % 10;
        int carry = (digits[digits.length - 1] + 1) / 10;
        digits[digits.length - 1] = sum;
        int i = digits.length - 2;
        while (i >= 0 && carry != 0) {
            int temp = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = temp;
            i--;
        }
        if (carry == 0) {
            return digits;
        }
        int[] ans = new int[digits.length + 1];
        System.arraycopy(digits, 0, ans, 1, digits.length);
        ans[0] = carry;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        Solution solution = new Solution();
        solution.plusOne(arr);
    }
}
