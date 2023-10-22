package meeting.GuangfaBank.code_2;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 37进制乘法
     *
     * @param str1 string字符串 数字1
     * @param str2 string字符串 数字2
     * @return string字符串
     */
    public String mul37(String str1, String str2) {
        long n1 = 0L, n2 = 0L;
        int m = str1.length(), n = str2.length();
        for (int i = m - 1; i >= 0; i--) {
            long num = getNum(str1.charAt(i));
            n1 += (long) (num * Math.pow(37, (m - i - 1)));
        }
        for (int i = n - 1; i >= 0; i--) {
            long num = getNum(str2.charAt(i));
            n2 += (long) (num * Math.pow(37, (n - i - 1)));
        }
        long ans = n1 * n2;
        String s = String.valueOf(ans);
        StringBuilder res = new StringBuilder();
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            num = num * 10 + s.charAt(i) - '0';
            int temp = num / 37;
            if (temp != 0) {
                res.append(toChar(temp));
            } else if (res.length() > 0) {
                res.append(toChar(temp));
            }
            num = num % 37;
            i++;
        }
        if (num != 0) {
            res.append(toChar(num));
        }
        return res.toString();
    }

    int getNum(Character c) {
        if (Character.isDigit(c)) {
            return c - '0';
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return 36;
    }

    char toChar(int num) {
        if (num < 10) {
            return (char) ('0' + num);
        }
        if (num < 36) {
            return (char) ('A' + num - 10);
        }
        return '$';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mul37("B", "A"));
    }
}