package algorithm.day_6.code_200;

/**
 * completion time = 2022.9.18
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    //判断grid[row],[column]是否是陆地
    public void dfs(char[][] grid, int row, int column) {
        //如果当前点越界，那就return
        if (!inArea(grid, row, column)) {
            return;
        }
        //如果当前点为0，表示这是水，或者为2，表示已经被标记过，return
        if (grid[row][column] == '0' || grid[row][column] == '2') {
            return;
        }
        if (grid[row][column] == '1') {
            grid[row][column] = '2';
        }
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }

    //判断该点是否在地图里面
    public boolean inArea(char[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
