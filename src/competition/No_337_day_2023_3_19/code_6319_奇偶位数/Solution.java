package competition.No_337_day_2023_3_19.code_6319_奇偶位数;

/**
 * completion time = 2023.3.19
 */
class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0) {
                even += n & 1;
            } else {
                odd += n & 1;
            }
            n = n >> 1;
        }
        return new int[]{even, odd};
    }
}
