package TowardsOffer.day_13_双指针_简单.code_58_I_翻转单词顺序;

/**
 * completion time = 2022.12.3
 */
class Solution {
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= s.length()) {
                break;
            }
            int begin = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            sb.insert(0, " ");
            sb.insert(0, s.substring(begin, i));
        }
        if (sb.isEmpty()) {
            return "";
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(""));
    }
}