package Random.code_224_基本计算器;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.11
 *
 * ps: 不是最优解
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("2-1 + 2"));
    }

    public int calculate(String s) {
        Deque<Character> op = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                Deque<Character> kuo = new ArrayDeque<>();
                kuo.push('(');
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        kuo.push('(');
                    }
                    if (s.charAt(j) == ')') {
                        kuo.pop();
                    }
                    if (kuo.isEmpty()) {
                        int calculate = calculate(s.substring(i + 1, j));
                        num.addLast(calculate);
                        i = j;
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {
                String sNum = getNum(s, i);
                i = i + sNum.length() - 1;
                Integer digit = Integer.valueOf(sNum);
                num.addLast(digit);
            } else {
                if (num.isEmpty()) {
                    num.add(0);
                }
                op.addLast(c);
            }
        }
        return cal(op, num);
    }

    int cal(Deque<Character> op, Deque<Integer> num) {
        Integer ans = num.pollFirst();
        while (!op.isEmpty()) {
            Integer sec = num.pollFirst();
            Character c = op.pollFirst();
            if (c == '+') {
                ans += sec;
            } else {
                ans -= sec;
            }
        }
        return ans;
    }

    String getNum(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}