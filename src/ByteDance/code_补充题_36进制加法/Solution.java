package ByteDance.code_补充题_36进制加法;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().add36Strings("1b", "2x"));
    }

    // k进制跟10进制比起来，其实就是将 %10 和 /10 变为 %k 和 /k
    public String add36Strings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int i = m - 1, j = n - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = getInt(num1.charAt(i)) + getInt(num2.charAt(j)) + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = getInt(num1.charAt(i)) + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            i--;
        }
        while (j >= 0) {
            int sum = +getInt(num2.charAt(j)) + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            j--;
        }
        if (carry != 0) {
            sb.append(getChar(carry));
        }
        return sb.reverse().toString();
    }

    int getInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        return c - 'a' + 10;
    }

    char getChar(int num) {
        if (num >= 0 && num <= 9) {
            return (char) ('0' + num);
        }
        return (char) (num - 10 + 'a');
    }
}
