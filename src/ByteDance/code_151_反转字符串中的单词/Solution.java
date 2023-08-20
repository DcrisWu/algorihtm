package ByteDance.code_151_反转字符串中的单词;

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int j = i;
                for (; j < s.length() && s.charAt(j) != ' '; j++) ;
                ans.insert(0, s, i, j);
                ans.insert(0, ' ');
                i = j;
            }
        }
        ans.delete(0, 1);
        return ans.toString();
    }
}