package BasicCoding.day_5.code_67;

/**
 * completion time = 2022.10.2
 */
public class Solution {
    public String addBinary(String a, String b) {
//        int len = Math.max(a.length(), b.length());
//        char[] temp_a = a.toCharArray();
//        char[] temp_b = b.toCharArray();
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuffer sb = new StringBuffer("");
        boolean carry = false;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                if (carry) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                if (a.charAt(i) == '1') {
                    carry = true;
                }else {
                    carry = false;
                }
            } else {
                if (carry) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if(a.charAt(i) == '1'){
                if(carry){
                    sb.append("0");
                }else {
                    sb.append("1");
                }
            }else {
                if(carry){
                    sb.append("1");
                    carry = false;
                }else {
                    sb.append("0");
                }
            }
            i--;
        }
        while (j >= 0){
            if(b.charAt(j) == '1'){
                if(carry){
                    sb.append("0");
                }else {
                    sb.append("1");
                }
            }else {
                if (carry){
                    sb.append("1");
                    carry = false;
                }else {
                    sb.append("0");
                }
            }
            j--;
        }
        if(carry){
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
