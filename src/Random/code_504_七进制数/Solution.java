package Random.code_504_七进制数;

class Solution {
    public String convertToBase7(int num) {
        boolean neg = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num / 7 != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        sb.reverse();
        if (neg) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}