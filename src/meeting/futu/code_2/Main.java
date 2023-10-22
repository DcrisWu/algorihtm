package meeting.futu.code_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
        System.out.println(new Main().cal("bbeeae"));
    }

    private String s;
    private int ans;

    public int cal(String s) {
        this.s = s;
        this.ans = 0;
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(Integer have, int length, int idx) {

        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                if ((have & (1 << ('c' - 'a'))) == 0 && (have & (1 << ('e' - 'a'))) == 0) {
                    if (length + 1 > ans) {
                        ans = length + 1;
                    }
                    dfs(have | 1 << (c - 'a'), length + 1, i + 1);
                }
            } else if (c == 'c') {
                if ((have & (1 << ('e' - 'a'))) == 0) {
                    if (length + 1 > ans) {
                        ans = length + 1;
                    }
                    dfs(have | 1 << (c - 'a'), length + 1, i + 1);
                }
            } else if (c == 'b') {
                if ((have & (1 << ('d' - 'a'))) == 0 && (have & (1 << ('f' - 'a'))) == 0) {
                    if (length + 1 > ans) {
                        ans = length + 1;
                    }
                    dfs(have | 1 << (c - 'a'), length + 1, i + 1);
                }
            } else if (c == 'd') {
                if ((have & (1 << ('f' - 'a'))) == 0) {
                    if (length + 1 > ans) {
                        ans = length + 1;
                    }
                    dfs(have | 1 << (c - 'a'), length + 1, i + 1);
                }
            } else {
                if (length + 1 > ans) {
                    ans = length + 1;
                }
                dfs(have | 1 << (c - 'a'), length + 1, i + 1);
            }
        }

    }
}

