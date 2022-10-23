package daily;

import java.util.Arrays;

public class july_12 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] ints = new int[m][n];
        for (int[] anInt : ints) {
            Arrays.fill(anInt, 0);
        }
        for (int[] index : indices) {
            int row = index[0];
            for (int i = 0; i < n; i++) {
                ints[row][i] += 1;
            }
            int column = index[1];
            for (int i = 0; i < m; i++) {
                ints[i][column] += 1;
            }
        }
        int count = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                if(i % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
