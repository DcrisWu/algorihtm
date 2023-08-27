package meeting.huawei;

import java.util.Scanner;

public class code_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (sc.hasNext()) {
            String op = sc.next();
            switch (op) {
                case "insert":
                    String word = sc.next();
                    i = insert(ans, i, word);
                    break;
                case "delete":
                    int step = sc.nextInt();
                    i = delete(ans, i, step);
                    break;

                case "move":
                    int stepm = sc.nextInt();
                    i = move(ans, i, stepm);
                    break;

                case "copy":
                    i = copy(ans, i);
                    break;

            }
        }
        ans.insert(i, "|");
        System.out.println(ans);
    }

    public static int insert(StringBuilder sb, int i, String s) {
        sb.insert(i, s);
        return i + s.length();
    }

    public static int delete(StringBuilder sb, int i, int len) {
        // 可以删除的长度 < len
        if (len < 0 || i + 1 < len) {
            return i;
        }
//        String head = sb.substring(0, i - len + 1);
//        String tail = sb.substring(i + 1);
        sb.delete(i - len, i);
        return i - len;
    }

    public static int move(StringBuilder sb, int i, int len) {
        if (i + len < 0 || i + len > sb.length()) {
            return i;
        }
        return i + len;
    }

    public static int copy(StringBuilder sb, int i) {
        String substring = sb.substring(0, i);
        sb.insert(0, substring);
        return i;
    }

}
