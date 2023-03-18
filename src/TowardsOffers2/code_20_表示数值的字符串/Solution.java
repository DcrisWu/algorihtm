package TowardsOffers2.code_20_表示数值的字符串;

/**
 * completion time = 2023.3.18
 */
class Solution {
    /**
     * ()表示可选
     * s -> num1 (e|E num2)
     * num1 -> (symbol) float | integer
     * num2 -> (symbol) integer
     * float -> integer. | .integer | integer.integer
     * integer -> 字符串都是数字
     */
    public boolean isNumber(String s) {
        s = s.trim();
        int eIndex = s.indexOf('e');
        int EIndex = s.indexOf('E');
        if (eIndex != -1 && EIndex != -1) {
            return false;
        }
        boolean hasE = eIndex != -1 || EIndex != -1;
        if (hasE) {
            int index = eIndex != -1 ? eIndex : EIndex;
            return parseNum1(s.substring(0, index)) && parseNum2(s.substring(index + 1));
        } else {
            return parseNum1(s);
        }
    }

    boolean parseNum1(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return parseFloat(s.substring(1)) || parseInteger(s.substring(1));
        } else {
            return parseFloat(s) || parseInteger(s);
        }
    }

    boolean parseNum2(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return parseInteger(s.substring(1));
        } else {
            return parseInteger(s);
        }
    }

    boolean parseFloat(String s) {
        int index = s.indexOf('.');
        if (index == -1) {
            return false;
        }
        if (index == 0) {
            return parseInteger(s.substring(1));
        }
        if (index == s.length() - 1) {
            return parseInteger(s.substring(0, s.length() - 1));
        }
        return parseInteger(s.substring(0, index)) && parseInteger(s.substring(index + 1));
    }

    boolean parseInteger(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}