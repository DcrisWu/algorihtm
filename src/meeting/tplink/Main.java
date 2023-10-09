package meeting.tplink;

import java.util.Arrays;

public class Main {
    public int solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        // pre不包括arr[i]
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pre == sum - arr[i] - pre) {
                return i;
            }
            pre += arr[i];
        }
        return -1;
    }
}
