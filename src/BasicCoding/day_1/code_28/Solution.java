package BasicCoding.day_1.code_28;

/**
 * completion time = 2022.10.1
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.strStr("a", "a");
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), len = needle.length();
        for (int i = 0; i <= n - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
