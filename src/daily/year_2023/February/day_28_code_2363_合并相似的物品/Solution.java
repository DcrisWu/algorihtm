package daily.year_2023.February.day_28_code_2363_合并相似的物品;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * completion time = 2023.2.28
 */
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i < items1.length && j < items2.length) {
            List<Integer> temp = new ArrayList<>();
            if (items1[i][0] == items2[j][0]) {
                temp.add(items1[i][0]);
                temp.add(items1[i][1] + items2[j][1]);
                i++;
                j++;
            } else if (items1[i][0] < items2[j][0]) {
                temp.add(items1[i][0]);
                temp.add(items1[i][1]);
                i++;
            } else {
                temp.add(items2[j][0]);
                temp.add(items2[j][1]);
                j++;
            }
            ans.add(temp);
        }
        while (i < items1.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(items1[i][0]);
            temp.add(items1[i][1]);
            i++;
            ans.add(temp);
        }
        while (j < items2.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(items2[j][0]);
            temp.add(items2[j][1]);
            j++;
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] i1 = {{2, 9}, {24, 4}, {11, 1}, {16, 3}, {1, 4}, {28, 3}, {23, 8}, {3, 3}};
        int[][] i2 = {{7, 6}, {12, 7}, {9, 5}, {22, 4}, {6, 3}, {17, 1}};
        solution.mergeSimilarItems(i1, i2);
    }
}
