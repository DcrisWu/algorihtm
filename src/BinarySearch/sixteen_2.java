package BinarySearch;

import java.util.Arrays;

/**
 * node_1300
 */
public class sixteen_2 {
    public static void main(String[] args) {
        int[] arr = {1547, 83230, 57084, 93444, 70879};
        sixteen_2 sixteen_2 = new sixteen_2();
        System.out.println(sixteen_2.findBestValue(arr, 71237));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        int l_min = target / n, r_min = (target - 1) / n + 1;
        //如果所有数都是arr[0]，都大于target，那么就返回min
        if (arr[0] * n > target) {
            return target - l_min * n <= r_min * n - target ? l_min : r_min;
        }
        //如果所有数的和都小于target，那么就返回arr[n-1]
        if (preSum[n - 1] <= target) {
            return arr[n - 1];
        }
        //否则，返回值在arr[0] ~ arr[n-1]之间
        int min = arr[0], max = arr[n - 1], val = min, index = 0;
        while (min <= max) {
            int mean = (min + max) >> 1;
            //寻找arr[i] <= mean的最大下标i
            int l = 0, r = n - 1, mark = 0;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (arr[mid] <= mean) {
                    mark = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int sum = preSum[mark] + mean * (n - mark - 1);
            if (sum <= target) {
                val = mean;
                index = mark;
                min = mean + 1;
            } else {
                max = mean - 1;
            }
        }

        int r_temp = preSum[index] + val * (n - index - 1) + (n - index - 1);
        int l_temp = preSum[index] + val * (n - index - 1);
        return r_temp - target >= target - l_temp ? val : val + 1;
    }
}

//    int l = 0, r = n - 1, mark = -1;
//        while (l <= r) {
//                int mid = (l + r) >> 1;
//                int sum = preSum[mid] + arr[mid] * (n - mid - 1);
//                if (sum <= target) {
//                mark = mid;
//                l = mid + 1;
//                } else {
//                r = mid - 1;
//                }
//                }
//                if (mark == n - 1) {
//                return arr[mark];
//                }
//                return (target - (preSum[mark] + arr[mark] * (n - mark - 1)) <= (preSum[mark+1] + arr[mark+1] * (n - mark - 2)) - target) ? arr[mark] : arr[mark + 1];


//        int min = target / n, max = arr[n - 1];
//        int l = 0, r = n - 1, mark = -1, value = l;
//        while (min <= max) {
//            int mean = (min + max) >> 1;
//            int sum = 0;
//            //寻找满足条件的最大下标
//            while (l <= r) {
//                int mid = (l + r) >> 1;
//                sum = preSum[mid] + arr[mid] * (n - mid - 1);
//                if (sum <= mean * n) {
//                    mark = mid;
//                    value = arr[mark];
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            if(sum <= target){
//                min = value +1;
//            }

//    }

//}
