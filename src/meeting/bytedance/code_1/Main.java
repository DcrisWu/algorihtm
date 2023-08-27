package meeting.bytedance.code_1;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        long ans = cal(s, t);
        int i = 0;
        while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i < s.length() && i < t.length()) {
            StringBuilder st = new StringBuilder(s);
            st.setCharAt(i, t.charAt(i));
            ans = Math.max(ans, cal(st.toString(), t));
        }
        int suffLen = 0;
        while (s.length() - suffLen > 0 && t.length() - suffLen > 0) {
            int x = s.length() - suffLen - 1;
            int y = t.length() - suffLen - 1;
            if (s.charAt(x) == t.charAt(y)) {
                suffLen++;
            } else {
                break;
            }
        }
        if (suffLen < s.length() && suffLen < t.length()) {
            StringBuilder st = new StringBuilder(s);
            st.setCharAt(s.length() - suffLen - 1, t.charAt(t.length() - suffLen - 1));
            ans = Math.max(ans, cal(st.toString(), t));
        }
        System.out.println(ans);
    }

    public static long cal(String s, String t) {
        int pre = 0;
        while (pre < s.length() && pre < t.length() && s.charAt(pre) == t.charAt(pre)) {
            pre++;
        }
        int suff = 0;
        while (s.length() - suff > 0 && t.length() - suff > 0) {
            int x = s.length() - suff - 1;
            int y = t.length() - suff - 1;
            if (s.charAt(x) == t.charAt(y)) {
                suff++;
            } else {
                break;
            }
        }
        return pre * suff;
    }
}
