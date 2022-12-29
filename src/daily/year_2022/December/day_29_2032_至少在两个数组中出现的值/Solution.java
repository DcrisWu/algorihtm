package daily.year_2022.December.day_29_2032_至少在两个数组中出现的值;

import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums1[0], map.getOrDefault(nums1[0], 0) + 1);
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] != nums1[i - 1]) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
        }
        map.put(nums2[0], map.getOrDefault(nums2[0], 0) + 1);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] != nums2[i - 1]) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
        }
        map.put(nums3[0], map.getOrDefault(nums3[0], 0) + 1);
        for (int i = 1; i < nums3.length; i++) {
            if (nums3[i] != nums3[i - 1]) {
                map.put(nums3[i], map.getOrDefault(nums3[i], 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > 1){
                ans.add(integer);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        Solution solution = new Solution();
        System.out.println(solution.twoOutOfThree(nums1, nums2, nums3));
    }
}
