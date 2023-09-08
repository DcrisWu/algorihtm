package classification.回溯.code_306_累加数;

/**
 * completion time = 2023.9.8
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("0"));
    }
    private String num;

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        return recursive(0, "", "", "");
    }

    boolean recursive(int idx, String first, String second, String expected) {
        for (int i = idx; i < num.length(); i++) {
            String now = num.substring(idx, i + 1);
            if (!isLegal(now)) {
                return false;
            }
            if (first.isEmpty()) {
                boolean b = recursive(i + 1, now, second, expected);
                if (b) {
                    return true;
                }
            } else if (second.isEmpty()) {
                boolean b = recursive(i + 1, first, now, add(first, now));
                if (b) {
                    return true;
                }
            } else if (now.equals(expected)) {
                if (i == num.length()-1){
                    return true;
                }
                boolean b = recursive(i + 1, second, now, add(second, now));
                if (b) {
                    return true;
                }
            }else if (now.length() > expected.length()){
                return false;
            }
        }
        return false;
    }

    boolean isLegal(String num) {
        return num.length() <= 1 || num.charAt(0) != '0';
    }

    String add(String first, String second) {
        StringBuilder f = new StringBuilder(first).reverse();
        StringBuilder s = new StringBuilder(second).reverse();
        int flen = f.length();
        int slen = s.length();
        int i = 0;
        int sum = 0;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i < flen && i < slen) {
            sum = (f.charAt(i) - '0' + s.charAt(i) - '0' + carry) % 10;
            carry = (f.charAt(i) - '0' + s.charAt(i) - '0' + carry) / 10;
            ans.append(sum);
            i++;
        }
        while (i < flen) {
            sum = (f.charAt(i) - '0' + carry) % 10;
            carry = (f.charAt(i) - '0' + carry) / 10;
            ans.append(sum);
            i++;
        }
        while (i < slen) {
            sum = (s.charAt(i) - '0' + carry) % 10;
            carry = (s.charAt(i) - '0' + carry) / 10;
            ans.append(sum);
            i++;
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
