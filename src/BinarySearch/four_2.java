package BinarySearch;

import java.util.Arrays;

/**
 * code_1552
 */
public class four_2 {
    /*
     * 排序后的position数组，最右-最左是磁力的最大值，题目求所有磁力中最大值的最小值
     * 假设mid = (left + mid) / 2
     * 然后遍历整个数组，查看满足position[j] - position[i] >= mid (i<j)的个数是否 >= m
     * 如果 >= m，表示ans至少为mid，则left = mid
     * 否则，right = mid-1
     * */
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n - 1]-position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1, pre = position[0];
            for (int j = 1; j < n; j++) {
                if (position[j] - pre >= mid) {
                    count++;
                    pre = position[j];
                }
            }
            if (count >= m) {
                left = mid+1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {79,74,57,22};
        maxDistance(arr,4);
    }
//    public boolean check(int x, int[] position, int m) {
//        //count表示已经放了的球，第一个球必定放在第一个点，所以count的初始值为1
//        int pre = position[0], count = 1;
//        for (int i = 1; i < position.length; i++) {
//            if (position[i] - pre >= x) {
//                pre = position[i];
//                count++;
//            }
//        }
//        return count >= m;
//    }
}
