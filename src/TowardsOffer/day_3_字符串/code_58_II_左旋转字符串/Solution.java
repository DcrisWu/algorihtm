package TowardsOffer.day_3_字符串.code_58_II_左旋转字符串;

/**
 * completion time = 2022.11.23
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
