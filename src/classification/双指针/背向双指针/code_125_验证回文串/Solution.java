package classification.双指针.背向双指针.code_125_验证回文串;

/**
 * completion time = 2023.3.20
 */
class Solution {
    /**
     * 如果不是字母或者数字，就跳过
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}