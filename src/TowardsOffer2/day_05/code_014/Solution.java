package TowardsOffer2.day_05.code_014;

/**
 * completion time = 2022.10.18
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*if (s1.length() > s2.length()) {
            return false;
        }
        int[] mark = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                count[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(mark,count)){
                return true;
            }
        }
        return false;*/

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        int[] mark = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(count[i] - mark[i]);
        }
        if(diff == 0){
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            char pop = s2.charAt(i - s1.length());
            char push = s2.charAt(i);
            if(pop != push){
                // 如果弹出前，子串中该字符的数量 <= s1中该字符的数量，弹出后diff++;
                if(count[pop-'a'] >= mark[pop-'a']){
                    diff++;
                }else {
                    diff--;
                }
                mark[pop-'a']--;
                // 在压入新字符前，子串中该字符的数量 < s1中该字符的数量，diff--
                if(mark[push-'a'] < count[push-'a']){
                    diff--;
                }else {
                    diff++;
                }
                mark[push-'a']++;
                if(diff == 0){
                    return true;
                }
            }
        }
        return false;
    }
}