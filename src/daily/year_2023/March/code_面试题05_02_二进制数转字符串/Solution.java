package daily.year_2023.March.code_面试题05_02_二进制数转字符串;

class Solution {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder("0.");
        for (int i = 0; i < 30; i++) {
            num *= 2.0;
            if (num >= 1.0) {
                ans.append(1);
                num -= 1.0;
            } else {
                ans.append(0);
            }
            if (num == 0) {
                return ans.toString();
            }
        }
        return "ERROR";
    }
}
