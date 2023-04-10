package competition.No_340_day_2023_4_9.code_6353_网格图中最少访问的格子数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.4.10
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        System.out.println(solution.minimumVisitedCells(grid));
    }

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = 0;
        // 单调栈：对于int[0]:自底向上增大，从右向左也是增大; 对于int[1]自底向上减小，从右向左也是减小
        // 每一列的单调栈
        ArrayList<int[]>[] colSt = new ArrayList[n];
        Arrays.setAll(colSt, e -> new ArrayList<int[]>());
        for (int i = m - 1; i >= 0; i--) {
            // 每一行的单调栈
            List<int[]> rowSt = new ArrayList<>();
            for (int j = n - 1; j >= 0; j--) {
                ArrayList<int[]> colStack = colSt[j];
                mn = Integer.MAX_VALUE;
                int g = grid[i][j];
                // 如果是最后一步
                if (j == n - 1 && i == m - 1) {
                    mn = 0;
                } else if (g > 0) {
                    // g > 0表示如果走到了这一步，还可以移动
                    // 对于行单调栈
                    int k = search(rowSt, g + j);
                    if (k < rowSt.size()) {
                        mn = Math.min(mn, rowSt.get(k)[0]);
                    }
                    k = search(colStack, g + i);
                    if (k < colStack.size()) {
                        mn = Math.min(mn, colStack.get(k)[0]);
                    }
                }
                // 如果 mn == Integer.MAX_VALUE ，说明当前位置不可达
                if (mn == Integer.MAX_VALUE) {
                    continue;
                }
                // 在原有的基础上，走一步，就是(i,j)的步数
                mn += 1;
                // 维护单调栈
                // 行单调栈维护的是列信息，列单调栈维护的是行信息
                while (!rowSt.isEmpty() && mn <= rowSt.get(rowSt.size() - 1)[0]) {
                    rowSt.remove(rowSt.size() - 1);
                }
                rowSt.add(new int[]{mn, j});
                while (!colStack.isEmpty() && mn <= colStack.get(colStack.size() - 1)[0]) {
                    colStack.remove(colStack.size() - 1);
                }
                colStack.add(new int[]{mn, i});
            }
        }
        return mn == Integer.MAX_VALUE ? -1 : mn;
    }

    // 返回单调栈 st 中 int[1] 最大的 <= target 的元素在单调栈中的下标
    // 我们希望找到单调栈中尽量尽量小的int[0]，所以要尽量往单调栈的底部去找，但是 int[1] <= target，而且int[1]递增

    /**
     * 单调栈的内部结构，下标小的是栈底
     * 下标：  3       2       1       0
     * 元素:  [5,1]   [3,2]   [2,4]   [1,5]
     */
    private int search(List<int[]> st, int target) {
        int l = 0, r = st.size() - 1;
        int ans = st.size();
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (st.get(mid)[1] <= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


}
