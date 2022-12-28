package daily.year_2022.December.day_28_code_1750_删除字符串两端相同字符后的最短长度;

/**
 * completion time = 2022.12.8
 */
class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char c = s.charAt(i);
            while (i + 1 < j && s.charAt(i + 1) == c) {
                i++;
            }
            while (j - 1 > i && s.charAt(j - 1) == c) {
                j--;
            }
            i++;
            j--;
        }
        return j-i+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
