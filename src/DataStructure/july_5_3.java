package DataStructure;

import java.util.*;

public class july_5_3 {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 1};
        System.out.println(subarraySum(arr, 0));
    }

//    public static int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int[] l = new int[n];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//        //l[i]表示第i个元素及其左边的元素的和
//        l[0] = nums[0];
//        map.put(l[0], 1);
//        if (l[0] == k) {
//            count += map.get(l[0]);
//        }
//        for (int i = 1; i < n; i++) {
//            l[i] = l[i - 1] + nums[i];
//            if (map.containsKey(l[i])) {
//                map.get(l[i]);
//                map.replace(l[i], map.get(l[i]) + 1);
//            } else {
//                map.put(l[i], 1);
//            }
//
//            if (l[i] == k) {
//                count++;
//            }
//            if (map.containsKey(k - l[i])) {
//                count += map.get(k - l[i]);
//            }
//        }
//        return count;
//    }

    public static int subarraySum(int[] nums, int k) {
        //pre表示第i个及之前的数的和
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
