package TowardsOffers2.code_8_字符串转换整数_atoi;

class Solution {
    public int myAtoi(String s) {
        String trim = s.trim();
        boolean sign = true;
        int index = 0;
        if (trim.isEmpty()){
            return 0;
        }
        if (trim.charAt(index) == '-') {
            sign = false;
            index++;
        } else if (trim.charAt(index) == '+') {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (index < trim.length() && trim.charAt(index) == '0') {
            index++;
        }
        while (index < trim.length() && trim.charAt(index) >= '0' && trim.charAt(index) <= '9') {
            sb.append(trim.charAt(index));
            index++;
        }
        if (sb.toString().equals("")){
            return 0;
        }
        if (sb.length() > 10){
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long temp = Long.parseLong(sb.toString());
        if (!sign){
            temp *= -1;
        }
        if (temp < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if (temp > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else {
            return (int) temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(Integer.MAX_VALUE);
    }
}
