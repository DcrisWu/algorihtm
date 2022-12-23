package TowardsOffer2_Special.day_1_整数位运算.code_001_整数除法;

/**
 * completion time = 2022.10.14
 */
public class Solution {
    public int divide(int a1, int b1) {
        if (a1 == Integer.MIN_VALUE && b1 == -1) {
            return Integer.MAX_VALUE;
        }
        long a = a1, b = b1;
        int k = Integer.MAX_VALUE;
        boolean sign = (a >= 0 && b > 0) || (a < 0 && b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        int a_len = getBinaryLength(a);
        int b_len = getBinaryLength(b);
        long temp_a = a;
        int cal = 0;
        int shift = b_len;
        while (a_len - shift >= 0) {
            System.out.println(Integer.toBinaryString((int) temp_a));
            cal = cal << 1;
            int v = (int) (Math.pow(2, a_len - shift) - 1);
            long low = temp_a & v;
            temp_a = temp_a >> (a_len - shift);
            if (temp_a >= b) {
                cal = cal | 1;
                long high = temp_a - b;
//                a_len = getBinaryLength(left) + a_len - shift;
                temp_a = (high << (a_len - shift)) + low;
            } else {
                temp_a = (temp_a << (a_len - shift)) + low;
            }
            shift++;
        }
        if (sign) {
            return cal;
        } else {
            return cal * -1;
        }
    }

    public int getBinaryLength(long val) {
        int len = 0;
        while (val > 0) {
            val = val >> 1;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.rotateRight(10, 2));
//        System.out.println(Integer.bitCount(100));
//        System.out.println(10 << 2);
//        System.out.println(Integer.toBinaryString(10));
//
//        int a = 10;
//        int b = a << 2;
//        System.out.println(a);
//        System.out.println(b);
        Solution solution = new Solution();
        System.out.println(solution.divide(2147483647, 3));
//        System.out.println(Integer.toBinaryString(2));
//        System.out.println(Integer.toBinaryString(-3));
    }
}
