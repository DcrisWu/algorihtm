package ByteDance.code_6_Z字形变换;

/**
 * completion time = 2022.12.9
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] str = new char[numRows][s.length()];
        int i = 0;
        int col = 0;
        int row = 0;
        // 当numRows >= 2时
        while (i < s.length()) {
            while (i < s.length() && row < numRows) {
                str[row][col] = s.charAt(i);
                row += 1;
                i++;
            }
            col++;
            row = numRows - 2;
            while (i < s.length() && row >= 0) {
                str[row][col] = s.charAt(i);
                row -= 1;
                i++;
            }
            col++;
            row = 1;
        }
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int m = 0; m < s.length(); m++) {
                if (str[j][m] != '\u0000') {
                    ans.append(str[j][m]);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}