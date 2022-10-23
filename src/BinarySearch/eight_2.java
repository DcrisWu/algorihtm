package BinarySearch;

/**
 * code_275
 */
public class eight_2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1, ans = 0;
        while (left <= right) {
            //客观事实：有n - mid篇论文至少被引用了citations[mid]次
            int mid = (left + right) >> 1;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
