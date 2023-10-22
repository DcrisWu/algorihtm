package ByteDance.code_43_字符串相乘;

/**
 * completion time = 2023.10.22
 */
class Solution {
    // 字符串乘法的关键是一位一位相乘，同时模拟字符串相加
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int m = num1.length(), n = num2.length();
        for (int i = m - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            temp.append("0".repeat(Math.max(0, m - 1 - i)));
            int carry = 0;
            int bit = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int sum = bit * (num2.charAt(j) - '0') + carry;
                temp.append(sum % 10);
                carry = sum / 10;
            }
            // 注意，如果是乘法的话，carry不一定是个位数，所以还是要取模
            while (carry != 0) {
                temp.append(carry % 10);
                carry /= 10;
            }
            ans = add(ans, temp.reverse());
        }
        return ans.toString();
    }

    StringBuilder add(StringBuilder a, StringBuilder b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
            j--;
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "6"));
    }
}