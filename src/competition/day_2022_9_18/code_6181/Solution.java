package competition.day_2022_9_18.code_6181;

public class Solution {
    public int longestContinuousSubstring(String s) {
        int index = 1, n = s.length();
        int count = 1,ans = 1;
        while (index < n) {
            if (s.charAt(index) == s.charAt(index - 1) + 1) {
                count++;
                ans = Math.max(count,ans);
            }else {
                count = 1;
            }
            index++;
        }
        return ans;
    }
}
