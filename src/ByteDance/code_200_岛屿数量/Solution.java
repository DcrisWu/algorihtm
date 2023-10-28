package ByteDance.code_200_岛屿数量;

/**
 * completion time = 2023.10.27
 */
class Solution {
    private char[][] grip;
    private boolean[][] visit;
    private int[][] change = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        this.grip = grid;
        visit = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grip.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(i, j)) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int i, int j) {
        visit[i][j] = true;
        for (int[] ch : change) {
            int x = i + ch[0];
            int y = j + ch[1];
            if (check(x, y)) {
                dfs(x, y);
            }
        }
    }

    boolean check(int x, int y) {
        return x >= 0 && x < grip.length && y >= 0 && y < grip[0].length && grip[x][y] == '1' && !visit[x][y];
    }
}