package TowardsOffer2_Special.day_1_整数位运算.code_002_二进制加法;

/**
 * completion time = 2022.10.14
 */
public class Solution {
    public String addBinary(String a, String b) {
        boolean sum = false, carry = false;
        StringBuffer cal = new StringBuffer("");
        StringBuffer first = new StringBuffer(a);
        StringBuffer second = new StringBuffer(b);
        first.reverse();
        second.reverse();
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            boolean one = first.charAt(i) == '1';
            boolean two = second.charAt(j) == '1';
            sum = one ^ two ^ carry;
            carry = (one & two) || (one | two) & carry;
            if (sum) {
                cal.append(1);
            } else {
                cal.append(0);
            }
            i++;
            j++;
        }
        while (i < first.length()){
            boolean one = first.charAt(i) == '1';
            sum = one ^ carry;
            carry = one & carry;
            if(sum){
                cal.append(1);
            }else {
                cal.append(0);
            }
            i++;
        }
        while (j < second.length()){
            boolean one = second.charAt(j) == '1';
            sum = one ^ carry;
            carry = one & carry;
            if(sum){
                cal.append(1);
            }else {
                cal.append(0);
            }
            j++;
        }
        if (carry){
            cal.append(1);
        }
        return cal.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("101010", "10111"));
    }
}
