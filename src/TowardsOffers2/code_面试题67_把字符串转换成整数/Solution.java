package TowardsOffers2.code_面试题67_把字符串转换成整数;

class Solution {
    public int strToInt(String str) {
        str = str.trim();
        String Int = "2147483648";
        if (str.isEmpty()) {
            return 0;
        }
        boolean sign = true;
        int i = 0;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = false;
            i++;
        }
        StringBuilder num = new StringBuilder();
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            num.append(str.charAt(i));
            i++;
        }
        String s = num.toString();
        if (s.isEmpty()) {
            return 0;
        }
        if (sign) {
            if (s.length() > Int.length()) {
                return Integer.MAX_VALUE;
            }
            if (s.length() == Int.length()) {
                if (s.compareTo(Int) < 0) {
                    return Integer.parseInt(s);
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.parseInt(s);
        } else {
            if (s.length() > Int.length()) {
                return Integer.MIN_VALUE;
            }
            if (s.length() == Int.length()) {
                if (s.compareTo(Int) < 0) {
                    return -Integer.parseInt(s);
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            return -Integer.parseInt(s);
        }
    }
}
