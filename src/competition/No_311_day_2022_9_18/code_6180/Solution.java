package competition.No_311_day_2022_9_18.code_6180;

public class Solution {
    public int smallestEvenMultiple(int n) {
        return n * 2 / cal(2, n);
    }

    public int cal(int a, int b) {
        int max = Math.max(a, b);
        int min = a == max ? b : a;
        if (max % min == 0) {
            return min;
        } else {
            return cal(min, max % min);
        }
    }
}
