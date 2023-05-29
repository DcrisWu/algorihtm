package basicAlgorithm.day_4.code_986;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.9.16
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[][]{};
        }
        //i表示firstList的下标，j表示secondList的下标
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                ans.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] re = new int[ans.size()][2];
        for(int k = 0;k<ans.size();k++){
            re[k][0] = ans.get(k)[0];
            re[k][1] = ans.get(k)[1];
        }
        return re;
    }
}
