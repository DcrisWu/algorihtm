package BinarySearch;

import java.util.Arrays;

/**
 * code_1498
 */
public class fifteen_2 {
    private int[] f;
    private int p = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {

        int n = nums.length, cnt = 0;
        pretreatment(n);
        Arrays.sort(nums);
        for (int i = 0; i < n && nums[i] * 2 <= target; i++) {
            //mark表示满足条件的最大元素的下标
            int l = i, r = n - 1, mark = i;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] + nums[i] <= target) {
                    mark = mid;
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }
            }
//            int num = (int) (Math.pow(2, mark - i) % p);
//            cnt = (cnt+num)% p;
            int num = f[mark - i];
            cnt = (cnt + num) % p;
        }
        return cnt;
    }

    public void pretreatment(int n) {
        f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; ++i) {
            f[i] = (f[i - 1] << 1) % p;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 6, 7, 8};
        fifteen_2 fifteen_2 = new fifteen_2();
        System.out.println(fifteen_2.numSubseq(arr, 10));
        System.out.println((int) (Math.pow(2, 1000) % (1e9 + 7)));
    }
}
