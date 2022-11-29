package daily.year_2022.July;

import java.util.ArrayList;
import java.util.List;


public class july_4 {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
        int min = arr[1] - arr[0];
        List<List<Integer>> list = new ArrayList();
        List<Integer> ini = new ArrayList<>();
        ini.add(arr[0]);
        ini.add(arr[1]);
        list.add(ini);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.clear();
                list.add(temp);
            } else if (arr[i + 1] - arr[i] == min) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.add(temp);
            }
            for (List<Integer> integers : list) {
                System.out.println(integers);
            }
        }

        for (List<Integer> integers : list) {
            System.out.println(integers);
        }

        return list;
    }

//    public static int absolute(int a) {
//        if (a < 0) {
//            return -a;
//        } else return a;
//    }


    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (pivot <= nums[high] && low < high) {
                high--;
            }
            nums[low] = nums[high];
            while (pivot >= nums[low] && low < high) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public static void quicksort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);
            quicksort(nums, low, pivot - 1);
            quicksort(nums, pivot + 1, high);
        }
    }


    public static void main(String[] args) {
//        List list = Collections.singletonList(new int[]{4, 2, 1, 3});
//        int[] arr = {40,11,26,40,27,-20};//1 2 4 3
        int[] arr = {1, 3, 4, 1};
        quicksort(arr, 0, arr.length - 1);
//        minimumAbsDifference(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

}
