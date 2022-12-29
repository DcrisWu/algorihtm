package TowardsOffers2.code_40_最小的k个数;

import java.util.*;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0;i<k;i++){
            ans[i] = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        int[] leastNumbers = solution.getLeastNumbers(arr, 2);
    }
}
