package BinarySearch;

import java.util.Arrays;
/**
 * code_1574
 */
public class fourteen_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,0,7,8,9};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 1;
        //如果arr本身就是升序的，就返回0
        while (i < n && arr[i - 1] <= arr[i]) {
            i++;
        }
        if (i == n) {
            return 0;
        }
        //假设删除左边，只保留右边
        int j = n - 1;
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        //假设右边是最长升序序列，要把左边全部删除，那么ans = j
        int ans = j;
        int l = 0, r = j;
        //假如要删除中间，保留左右两边
        while (l < i && r < n) {
            if (arr[l] <= arr[r]) {
                ans = Math.min(ans, r - l - 1);
                l++;
            } else {
                r++;
            }
        }
        //假如删除右边，只保留左边，再取最小值
        ans = Math.min(ans,n-i);
        return ans;
    }
}
