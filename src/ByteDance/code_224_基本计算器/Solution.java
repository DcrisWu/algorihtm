package ByteDance.code_224_基本计算器;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.29
 */
class Solution {
    // 本题的解题关键是，用双栈去模拟操作和数
    // 然后遇到 ) + -时候，就进行一次运算判断，也就是说进行运算前，需要判断一下ops，最后一个字符不能为 (，只有为 + 或者 - 时候才可以进行运算，如果是 ( 就直接出栈
    // 如果遇到一个符号，那么就需要进行判断，如果是第一个字符 || 上一个字符是 ( + -的时候，需要先压入一个 0，注意：如果前面是 ) 不可以压栈 0
    // 只能将 ( + - 进行压栈
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        // 将所有的空格去掉
        // 存放所有的操作，包括 +/-
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果是数字
            if (Character.isDigit(c)) {
                int j = i;
                for (; j < n; j++) {
                    if (!Character.isDigit(s.charAt(j))) {
                        break;
                    }
                }
                nums.addLast(Integer.valueOf(s.substring(i, j)));
                i = j - 1;
            } else {
                if (c == '(') {
                    ops.addLast('(');
                } else if (c == ')') {
                    while (!ops.isEmpty()) {
                        // 只有当操作数是 + 和 - 时候，才可以进行运算
                        if (ops.peekLast() == '(') {
                            ops.pollLast();
                            break;
                        } else {
                            // 每遇到一个符号，进行一次运算
                            cal(nums, ops);
                        }
                    }
                } else {
                    // 如果遇到一个负号，那么就需要进行判断，如果是第一个字符 || 上一个字符是 ( + -的时候，需要先压入一个 0，注意：如果前面是 ) 不可以压栈 0
                    if (c == '-' && (nums.isEmpty() || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                        nums.addLast(0);
                    }
                    // 只有当操作数是 + 和 - 时候，才可以进行运算
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        // 每遇到一个符号，进行一次运算
                        cal(nums, ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.peekFirst();
    }

    void cal(Deque<Integer> nums, Deque<Character> ops) {
        Character op = ops.pollLast();
        int b = nums.pollLast(), a = nums.pollLast();
        int ans = op == '+' ? a + b : a - b;
        nums.addLast(ans);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}