package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * code_658
 */
public class two_1 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        for (Integer closestElement : findClosestElements(arr, 3, 5)) {
            System.out.print(closestElement);
            System.out.print(' ');
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int index = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (arr[index] != x) {
            if (left >= 0 && left < n && right >= 0 && right < n) {
                index = Math.min(left, right);
            } else if (left >= 0 && left < n) {
                index = left;
            } else {
                index = right;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (k == 1 && n > 1) {
            int temp = arr[index + 1];
            if ((x - arr[index]) > (temp - x)) {
                ans.add(temp);
            } else {
                ans.add(arr[index]);
            }
        } else if (k == 1) {
            ans.add(arr[index]);
        } else {
            int min = index, max = index;
            while (max - min + 1 < k) {
                if (max + 1 >= n) {
                    min--;
                } else if (min - 1 < 0) {
                    max++;
                } else {
                    if (x - arr[min - 1] > arr[max + 1] - x) {
                        max++;
                    } else {
                        min--;
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }
}
