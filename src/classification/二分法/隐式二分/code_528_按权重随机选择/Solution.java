package classification.二分法.隐式二分.code_528_按权重随机选择;

import java.util.Random;

/**
 * completion time = 2023.3.24
 * 前缀和+随机数+二分法
 */
class Solution {

    private int[] preSum;
    Random random;
    private int sum;

    public Solution(int[] w) {
        this.preSum = new int[w.length];
        int sum = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
            sum += w[i];
        }
        this.sum = sum;
        random = new Random();
    }

    public int pickIndex() {
        int target = random.nextInt(sum);
        int l = 0, r = preSum.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (preSum[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));

    }
}
