package ByteDance.code_7_整数反转;

/**
 * completion time = 2022.12.9
 */
class Solution {
    public int reverse(int x) {
        boolean sign = x >= 0;
        StringBuilder sb;
        String temp = String.valueOf(x);
        if (sign) {
            sb = new StringBuilder(temp);
        } else {
            sb = new StringBuilder(temp.substring(1));
        }
        int len = String.valueOf(Integer.MAX_VALUE).length();
        sb.reverse();
        if (sb.length() < len) {
            if (sign) {
                return Integer.parseInt(sb.toString());
            } else {
                return Integer.parseInt(sb.toString()) * -1;
            }
        } else {
            if (sb.toString().equals("2147483648") && !sign) {
                return Integer.MIN_VALUE;
            }
            String s = sb.toString();
            String max = "2147483648";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > max.charAt(i)) {
                    return 0;
                }else if (s.charAt(i) < max.charAt(i)){
                    break;
                }

            }
            if (sign) {
                return Integer.parseInt(s);
            } else {
                return Integer.parseInt(s) * -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483412));
    }
}