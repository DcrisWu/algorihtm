package basicAlgorithm.day_15.code_91;

/**
 * 2022.9.26 不理解
 */
public class Solution {
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("");
//        sb.append('A'-'A'+1);
//        sb.append('B'-'A'+1);
//        sb.append('Z'-'A'+1);
//        System.out.println(sb);
        Solution solution = new Solution();
        solution.numDecodings("1264125");
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int tem = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(9 - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                cur += pre;
            }
            pre = tem;
        }
        return cur;
    }
    /*StringBuffer sb = new StringBuffer("");
        List<String> strings = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (sb.isEmpty()) {
                if(now != '0'){
                    sb.append(now);
                }else {
                    return 0;
                }
            } else {
                if (sb.charAt(sb.length() - 1) == '1') {
                    sb.append(now);
                } else if (sb.charAt(sb.length() - 1) == '2' && now > '0' && now < '7') {
                    sb.append(now);
                } else {
                    if(now == '0'){
                        return 0;
                    }
                    strings.add(sb.toString());
                    sb.delete(0, sb.length());
                    sb.append(now);
                }
            }
        }
        strings.add(sb.toString());
        int ans = 1;
        for (String string : strings) {
            int count = 1;
            if (string.length() < 3) {
                count = string.length();
            } else {
                int size = string.length();
                for (int i = 1; i < size; i++) {
                    count += size - i - 1;
                }
                count++;
            }
            ans *= count;
        }
        return ans;*/
}
