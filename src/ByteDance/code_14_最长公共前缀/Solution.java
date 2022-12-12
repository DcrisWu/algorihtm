package ByteDance.code_14_最长公共前缀;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(strs[i].length(),common.length()) && common.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            common = common.substring(0, j);
        }
        return common;
    }
}