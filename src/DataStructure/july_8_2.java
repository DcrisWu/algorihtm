package DataStructure;

public class july_8_2 {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int n = n1 + n2;
        int[] temp = new int[n];
        int carry = 0;
        int mul = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            int index = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                index = i + j + 1;
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                mul = (a * b + carry + temp[index]) % 10;
                carry = (a * b + carry + temp[index]) / 10;
                temp[index] = mul;
            }
            if (carry > 0) {
                temp[index - 1] = carry;
            }
            carry = 0;
            mul = 0;
        }
        StringBuilder ans = new StringBuilder("");
        int begin = 0;
        for(int i = 0;i<n;i++){
            if(temp[i] != 0){
                begin = i;
                break;
            }
        }
        if(begin == 0 && temp[begin] == 0){
            return "0";
        }
        for(int i = begin;i<n;i++){
            ans.append(temp[i]);
        }
        return ans.toString();
    }
}
