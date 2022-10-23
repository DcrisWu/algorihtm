package BasicCoding.day_6.code_58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = 0;
        int begin = 0, end = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                begin = i;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
                end = i;
            }
        }
        return end - begin;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon"));
    }
}
