package meeting.dji.code_1;

import java.util.Scanner;


class Solution {

    /* Write Code Here */
    public int calculateMaxTotalYie(int[][] cropField) {
        int m = cropField.length;
        int n = cropField[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += cropField[i][j];
                row[i] += cropField[i][j];
                col[j] += cropField[i][j];
            }
        }
        int max = 0;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] + col[j] > max) {
                    max = row[i] + col[j];
                    x = i;
                    y = j;
                }
            }
        }
        return total + row[x] + col[y] - cropField[x][y];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int cropField_rows = 0;
        int cropField_cols = 0;
        cropField_rows = in.nextInt();
        cropField_cols = in.nextInt();

        int[][] cropField = new int[cropField_rows][cropField_cols];
        for (int cropField_i = 0; cropField_i < cropField_rows; cropField_i++) {
            for (int cropField_j = 0; cropField_j < cropField_cols; cropField_j++) {
                cropField[cropField_i][cropField_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }


        res = new Solution().calculateMaxTotalYie(cropField);
        System.out.println(String.valueOf(res));

    }
}

