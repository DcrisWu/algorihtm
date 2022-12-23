package TowardsOffer2_Special.day_1_整数位运算.code_003_前n个数字二进制中1的个数;

/**
 * completion time = 2022.10.14
 */
public class Solution {
    public int[] countBits(int n) {
/*        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;*/
        int bits[] = new int[n + 1];
        int highest = 0;
        for (int i = 1; i <= n; i++) {
            //如果 i 是 2 的次幂
            if ((i & (i - 1)) == 0) {
                highest = i;
            }
            // i 就是 在 i-highest前面加了个1
            bits[i] = bits[i - highest] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBits(2));
        System.out.println(Integer.bitCount(11));

    }
}
