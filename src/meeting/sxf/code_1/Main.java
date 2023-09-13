package meeting.sxf.code_1;

import java.util.Scanner;

public class Main {

    public String get_substr (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int begin = i;
            for (int j = i + 1; j < s.length() && s.charAt(j) == c; j++) {
                i = j;
            }
            sb.append(s, begin, i + 1);
            int count = check(sb, c);
            if (count >= 3) {
                sb.delete(sb.length() - count, sb.length());
            }
        }
        return sb.toString();
    }
    // 返回字符串中 == c的长度
    public int check(StringBuilder sb, char c) {
        int idx = sb.length() - 1;
        int count = 0;
        while (idx >= 0 && sb.charAt(idx) == c) {
            count++;
            idx--;
        }
        return count;
    }
}
