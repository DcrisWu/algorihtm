package ByteDance.code_79_单词搜索;

/**
 * completion time = 2023.10.22
 */
class Solution {
    private char[][] board;
    private boolean[][] visit;
    private String word;
    private int[][] change = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        this.word = word;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, 0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int idx) {
        // 进入dfs函数之前就判断过是否可以访问
        // 如果是最后一个，因为之前已经check过了，所以直接返回true
        if (idx == word.length() - 1) {
            return true;
        }
        visit[i][j] = true;
        boolean judge = false;
        for (int[] ints : change) {
            int x = ints[0] + i;
            int y = ints[1] + j;
            if (check(x, y, idx + 1)) {
                if (dfs(x, y, idx + 1)) {
                    judge = true;
                    break;
                }
            }
        }
        visit[i][j] = false;
        return judge;
    }

    boolean check(int i, int j, int idx) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visit[i][j] && board[i][j] == word.charAt(idx);
    }

}