package DataStructure;

import java.util.Arrays;

public class july_3_3 {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //初始化最小值和最大值
        int min = 0;
        int max = n - 1;
        int num = 1;
        while(min <= max){
            int i = min;
            int j = min;
            for (; j <= max; j++) {
                ans[i][j] = num;
                num++;
            }
            if(num > n*n){
                break;
            }
            //撤回最后一步
            j--;
            i++;
            for (; i <= max; i++) {
                ans[i][j] = num;
                num++;
            }
            //撤回最后一步
            i--;
            j--;
            for (; j >= min; j--) {
                ans[i][j] = num;
                num++;
            }
            //撤回最后一步
            j++;
            i--;
            for (; i > min; i--) {
                ans[i][j] = num;
                num++;
            }
            //撤回最后一步
            i++;
            min++;
            max--;
        }

        return ans;
    }

    public static void main(String[] args) {
        for (int[] ints : generateMatrix(5)) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(' ');
            }
            System.out.println();
        }

    }
}
