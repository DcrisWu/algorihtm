package BinarySearch;

/**
 * code_875
 */
public class four_1 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        minEatingSpeed(arr,8);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = (int) 1e9;
        while (min < max) {
            int k = (min + max) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile - 1) / k + 1;
            }
            //如果需要的时间 < h，说明k选大了
            //注意：没有等号的表达式，在进行二分运算时，mid要+1
            if (hours > h) {
                min = k + 1;
            } else {
                max = k;
            }
        }
        return min;
    }
}
