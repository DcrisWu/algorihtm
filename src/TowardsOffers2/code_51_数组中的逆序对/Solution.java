package TowardsOffers2.code_51_数组中的逆序对;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }
        int count = 0;
        int mid = (begin + end) >> 1;
        count += mergeSort(nums, begin, mid);
        count += mergeSort(nums, mid + 1, end);
        int i = 0, j = 0;
        int[] left = Arrays.copyOfRange(nums, begin, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);
        int index = begin;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[index++] = left[i++];
            } else {
                nums[index++] = right[j++];
                count += left.length - i;
            }
        }
        while (i < left.length) {
            nums[index++] = left[i++];
        }
        while (j < right.length) {
            nums[index++] = right[j++];
        }
        return count;
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(0);
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        for (Integer integer : set.tailSet(2, false)) {
//            System.out.println(integer);
//        }
        int[] arr = {7, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(arr));
    }
}
