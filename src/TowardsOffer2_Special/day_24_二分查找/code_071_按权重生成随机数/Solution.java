package TowardsOffer2_Special.day_24_二分查找.code_071_按权重生成随机数;

import java.util.Random;

/**
 * completion time = 2022.11.4
 */
class Solution {

    private int[] preSum;
    private int sum = 0;
    Random random = new Random();

    public Solution(int[] w) {
        preSum = new int[w.length];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
        sum = preSum[w.length - 1] + w[w.length - 1];
    }

    public int pickIndex() {
        int nextInt = random.nextInt(sum);
        int l = 0, r = preSum.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nextInt >= preSum[mid]) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        Solution solution = new Solution(arr);
        System.out.println(solution.pickIndex());
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(random.nextInt(10));
//        }
    }
}