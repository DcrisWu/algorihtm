package classification.匹配问题.code_1947_最大兼容性评分和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*private int[][] students;
    private int[][] mentors;
    private boolean[] visit;
    int ans = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.mentors = mentors;
        this.students = students;
        visit = new boolean[students.length];
        dfs(new ArrayList<>());
        return ans;
    }

    // 对students进行全排列
    void dfs(List<int[]> pre) {
        if (pre.size() == visit.length) {
            int now = 0;
            for (int i = 0; i < pre.size(); i++) {
                for (int j = 0; j < mentors[i].length; j++) {
                    now += pre.get(i)[j] == mentors[i][j] ? 1 : 0;
                }
            }
            if (now > ans) {
                ans = now;
            }
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                pre.add(students[i]);
                visit[i] = true;
                dfs(pre);
                visit[i] = false;
                pre.remove(pre.size() - 1);
            }
        }
    }*/

    // dp，超纲了
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        int[][] g = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    g[i][j] += students[i][k] == mentors[i][k] ? 1 : 0;
                }
            }
        }

        int[] f = new int[1 << m];
        for (int mask = 1; mask < (1 << m); mask++) {
            int c = Integer.bitCount(mask);
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) == 1) {
                    f[mask] = Math.max(f[mask], f[mask ^ (1 << i)] + g[c - 1][i]);
                }
            }
        }
        return f[(1 << m) - 1];
    }
}
