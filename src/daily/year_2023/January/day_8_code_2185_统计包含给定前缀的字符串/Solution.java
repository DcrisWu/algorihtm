package daily.year_2023.January.day_8_code_2185_统计包含给定前缀的字符串;

class Solution {
    public int prefixCount(String[] words, String pref) {
        int len = pref.length();
        int count = 0;
        for (String word : words) {
            if (word.length() < len){
                continue;
            }
            if (word.substring(0,len).equals(pref)){
                count++;
            }
        }
        return count;
    }
}
