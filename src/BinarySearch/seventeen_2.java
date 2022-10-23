package BinarySearch;

/**
 * code_1901
 */
public class seventeen_2 {
    public static void main(String[] args) {
        int[][] arr = {{7,6},{2,5},{3,4},{1,2},{2,1}};
        seventeen_2 seventeen_2 = new seventeen_2();
        System.out.println(seventeen_2.findPeakGrid(arr));
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m - 1, tempIndex = 0;
//        ,row = 0
        int[] ans = new int[2];
        while (l <= r) {
            int mid = (l + r) >> 1;
//            row = mid;
            tempIndex = 0;
            int max = mat[mid][0];
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > max) {
                    tempIndex = i;
                    max = mat[mid][i];
                }
            }
            if ((mid == 0 && mat[mid][tempIndex] > mat[mid + 1][tempIndex]) || (mid == m - 1 && mat[mid][tempIndex] > mat[mid - 1][tempIndex]) ||
                    (mat[mid][tempIndex] > mat[mid + 1][tempIndex] && mat[mid][tempIndex] > mat[mid - 1][tempIndex])) {
//                ans[0] = mid;
//                ans[1] = tempIndex;
//                break;
                return new int[]{mid,tempIndex};
            }
            if (mat[mid][tempIndex] < mat[mid+ 1][tempIndex ]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
