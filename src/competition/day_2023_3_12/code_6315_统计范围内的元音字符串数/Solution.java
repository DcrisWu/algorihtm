package competition.day_2023_3_12.code_6315_统计范围内的元音字符串数;

/**
 * completion time = 2023.3.12
 */
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (judge(word.charAt(0)) && judge(word.charAt(word.length() - 1))) {
                ans++;
            }
        }
        return ans;
    }

    boolean judge(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
