package Random.code_227_基本计算器II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.9
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (!Character.isDigit(c)) {
                op.addLast(c);
            } else {
                StringBuilder di = new StringBuilder();
                for (int j = i; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
                    di.append(s.charAt(j));
                    i = j;
                }
                if (!di.isEmpty()) {
                    Integer sec = Integer.valueOf(di.toString());
                    if (!op.isEmpty()) {
                        if (op.peekLast() == '*') {
                            op.pollLast();
                            Integer fir = num.pollLast();
                            num.addLast(fir * sec);
                        } else if (op.peekLast() == '/') {
                            op.pollLast();
                            Integer fir = num.pollLast();
                            num.addLast(fir / sec);
                        } else {
                            num.addLast(sec);
                        }
                    }else {
                        num.addLast(sec);
                    }
                }
            }
        }
        int ans = num.pollFirst();
        while (!op.isEmpty()){
            Character ope = op.pollFirst();
            Integer sec = num.pollFirst();
            if (ope == '+'){
                ans += sec;
            }else {
                ans -= sec;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
    }
}
