package BinarySearch;

/**
 * code_1712
 */
public class ten_2 {
    public static void main(String[] args) {
        ten_2 ten_2 = new ten_2();
        int[] arr = {2, 3, 5, 10};
        System.out.println(ten_2.waysToSplit(arr));
    }

    public int waysToSplit(int[] nums) {
        int n = nums.length, cnt = 0;
        int[] before = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            before[i] = before[i - 1] + nums[i - 1];
        }
        int total = before[n];
        //i表示left的最大下标
        for (int i = 1; i < n - 1 && before[i] * 3 <= total; i++) {
            int left = before[i];
            //二分查找求下限,即最小的mid,满足(mid >= left)
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (before[mid] - left >= left) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int j = l;
            //求二分查找的上限,right >= mid
//            l = j;
            r = n-1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (before[n] - before[mid] >= before[mid] - left) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int k = r;
            cnt = (int) ((cnt + k - j + 1) % (1e9+7));
        }
        return cnt;
    }
}
