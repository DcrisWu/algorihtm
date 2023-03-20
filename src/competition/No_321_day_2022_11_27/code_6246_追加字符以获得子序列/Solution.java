package competition.No_321_day_2022_11_27.code_6246_追加字符以获得子序列;

class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == t.length() ? 0 : t.length() - j;
    }
}