package TowardsOffers2.code_12_整数转罗马数字;

import java.io.FileInputStream;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }

    public String intToRoman(int num) {
        int count = 0;
        count = num / 1000;
        num %= 1000;
        StringBuilder sb = new StringBuilder();
        if (count > 0 && count <= 3) {
            for (int i = 0; i < count; i++) {
                sb.append("M");
            }
        }
        count = num / 100;
        num %= 100;
        if (count > 0 && count <= 3) {
            for (int i = 0; i < count; i++) {
                sb.append("C");
            }
        } else if (count == 4) {
            sb.append("CD");
        } else if (count == 5) {
            sb.append("D");
        } else if (count >= 6 && count < 9) {
            sb.append("D");
            for (int i = 5; i < count; i++) {
                sb.append("C");
            }
        } else if (count == 9) {
            sb.append("CM");
        }
        count = num / 10;
        num %= 10;
        if (count > 0 && count <= 3) {
            for (int i = 0; i < count; i++) {
                sb.append("X");
            }
        } else if (count == 4) {
            sb.append("XL");
        } else if (count == 5) {
            sb.append("L");
        } else if (count >= 6 && count < 9) {
            sb.append("L");
            for (int i = 5; i < count; i++) {
                sb.append("X");
            }
        } else if (count == 9) {
            sb.append("XC");
        }
        count = num;
        if (count > 0 && count <= 3) {
            for (int i = 0; i < count; i++) {
                sb.append("I");
            }
        } else if (count == 4) {
            sb.append("IV");
        } else if (count == 5) {
            sb.append("V");
        } else if (count >= 6 && count < 9) {
            sb.append("V");
            for (int i = 5; i < count; i++) {
                sb.append("I");
            }
        } else if (count == 9) {
            sb.append("IX");
        }
        return sb.toString();
    }


}