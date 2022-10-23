package DataStructure;

public class july_6_1 {
    public String addStrings(String num1, String num2) {
        int sum = 0;
        int carry = 0;
        int len_1 = num1.length() - 1;
        int len_2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder("");
        while (len_1 >= 0 && len_2 >= 0) {
            sum = (num1.charAt(len_1) - '0' + num2.charAt(len_2) - '0' + carry) % 10;
            ans.append(Integer.toString(sum));
            carry = (num1.charAt(len_1) - '0' + num2.charAt(len_2) - '0' + carry) / 10;
            len_1--;
            len_2--;
        }
        while (len_1 >= 0) {
            sum = (num1.charAt(len_1) - '0' + carry) % 10;
            ans.append(Integer.toString(sum));
            carry = (num1.charAt(len_1) - '0' + carry) / 10;
            len_1--;
        }
        while (len_2 >= 0) {
            sum = (num2.charAt(len_2) - '0' + carry) % 10;
            ans.append(Integer.toString(sum));
            carry = (num2.charAt(len_2) - '0' + carry) / 10;
            len_2--;
        }
        if(carry != 0){
            ans.append(Integer.toString(carry));
        }
        return ans.reverse().toString();
    }
}
