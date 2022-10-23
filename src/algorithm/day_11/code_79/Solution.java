package algorithm.day_11.code_79;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2022.9.23
 */
public class Solution {
    public static void main(String[] args) {
//        char[][] chars = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        char[][] chars = {{'b', 'b' }, {'a', 'b' }, {'b', 'a' }};
        Solution solution = new Solution();
        System.out.println(solution.exist(chars, "a"));
    }

    private boolean judge = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(used, i * n + j, board, m, n, word, -1);
                if (judge) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(Set<Integer> used, int index, char[][] board, int m, int n, String word, int found) {
        int row = index / n;
        int column = index % n;
        //found表示word中最近确定的字母
        if (board[row][column] == word.charAt(found + 1)) {
            if (found + 1 == word.length() - 1) {
                judge = true;
                return;
            } else {
                Set<Integer> nowUsed = new HashSet<>(used);
                nowUsed.add(index);
                if (inArea(board, row - 1, column, nowUsed)) {
                    dfs(nowUsed, (row - 1) * n + column, board, m, n, word, found + 1);
                }
                if (inArea(board, row + 1, column, nowUsed)) {
                    dfs(nowUsed, (row + 1) * n + column, board, m, n, word, found + 1);
                }
                if (inArea(board, row, column - 1, nowUsed)) {
                    dfs(nowUsed, index - 1, board, m, n, word, found + 1);
                }
                if (inArea(board, row, column + 1, nowUsed)) {
                    dfs(nowUsed, index + 1, board, m, n, word, found + 1);
                }
            }
        }
        return;
    }

    public boolean inArea(char[][] board, int x, int y, Set<Integer> used) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && !used.contains(x * board[0].length + y);
    }
}
