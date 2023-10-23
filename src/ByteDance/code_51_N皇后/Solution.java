package ByteDance.code_51_N皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.12.10
 */
class Solution {
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        List<StringBuilder> now = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            now.add(new StringBuilder().append(".".repeat(n)));
        }
        recursive(now, 0);
        return res;
    }

    void recursive(List<StringBuilder> have, int row) {
        if (row == n) {
            List<String> now = new ArrayList<>();
            for (StringBuilder sb : have) {
                now.add(sb.toString());
            }
            res.add(now);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(have, row, i)) {
                have.get(row).setCharAt(i, 'Q');
                recursive(have, row + 1);
                have.get(row).setCharAt(i, '.');
            }
        }
    }

    boolean check(List<StringBuilder> have, int x, int y) {
        // 检测行
        StringBuilder sb = have.get(x);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'Q' && i != y) {
                return false;
            }
        }
        // 检测列
        for (int i = 0; i < n; i++) {
            if (have.get(i).charAt(y) == 'Q' && i != x) {
                return false;
            }
        }
        // 检测斜着的列
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (have.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++) {
            if (have.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (have.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--) {
            if (have.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}