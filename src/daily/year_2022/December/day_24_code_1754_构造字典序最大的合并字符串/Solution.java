package daily.year_2022.December.day_24_code_1754_构造字典序最大的合并字符串;

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                s.append(word1.charAt(i));
                i++;
            } else {
                s.append(word2.charAt(j));
                j++;
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestMerge("abcabc", "abdcaba"));
    }

}
