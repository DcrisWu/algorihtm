package DataStructure;

import java.util.Arrays;

public class july_5_2 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] l = new int[n], r = new int[n];
        l[0] = 1;
        //l[i]表示i左侧的所有数的积，r[i]表示i右侧所有数的积
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            r[j] = r[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
//        Arrays.fill(arr, 0, 2, 1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        for (int i : productExceptSelf(arr)) {
            System.out.println(i);
        }
    }
}
