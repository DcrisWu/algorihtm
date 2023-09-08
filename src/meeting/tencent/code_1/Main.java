package meeting.tencent.code_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[][] arr = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        List<Integer> res = m.res(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private int[][] matrix;
    private boolean[][] visit;
    private int[][] change = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public List<Integer> res(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        this.matrix = arr;
        int m = matrix.length;
        int n = matrix[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j)) {
                    int area = dfs(i, j);
                    list.add(area);
                }
            }
        }
        Integer[] ans = new Integer[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
//        Arrays.sort(ans,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer a,Integer b){
//                return a-b;
//            }
//        });
        return list;
    }

    int dfs(int i, int j) {
        visit[i][j] = true;
        int ans = 1;
        for (int[] ch : change) {
            int x = ch[0] + i;
            int y = ch[1] + j;
            if (check(x, y)) {
                ans += dfs(x, y);
            }
        }
        return ans;
    }

    boolean check(int i, int j) {
        return i >= 0 && i < matrix.length &&
                j >= 0 && j < matrix[0].length &&
                !visit[i][j] && matrix[i][j] == 1;
    }
}
