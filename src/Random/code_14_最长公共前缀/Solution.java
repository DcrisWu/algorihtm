package Random.code_14_最长公共前缀;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int left = 0, right = strs.length - 1;
        return commonPrefix(strs, left, right);
    }

    String commonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) >> 1;
        String leftPrefix = commonPrefix(strs, left, mid);
        String rightPrefix = commonPrefix(strs, mid + 1, right);
        int i = 0;
        while (i < leftPrefix.length() && i < rightPrefix.length()) {
            if (leftPrefix.charAt(i) == rightPrefix.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return leftPrefix.substring(0,i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(arr));
    }
}
