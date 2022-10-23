package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class july_1_3 {

    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> part = new ArrayList<>();
                    part.add(nums[i]);
                    part.add(nums[l]);
                    part.add(nums[r]);
                    ans.add(part);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    List<Integer> part = new ArrayList<>();
                    part.add(nums[i]);
                    part.add(nums[L]);
                    part.add(nums[R]);
                    ans.add(part);
//                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (pivot <= nums[high] && low < high)    high--;
            nums[low] = nums[high];
            while (pivot >= nums[low] && low < high)     low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public static void quickSort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
//        List list = Collections.singletonList(new int[]{4, 2, 1, 3});
        july_1_3 july_1_3 = new july_1_3();
        int[] arr = {1, 3, 4, 1};//1 2 4 3
        july_1_3.quickSort(arr, 0, arr.length - 1);
//        minimumAbsDifference(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
