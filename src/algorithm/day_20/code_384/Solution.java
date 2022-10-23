package algorithm.day_20.code_384;

import java.util.*;

/**
 * completion time = 2022.9.28
 */
public class Solution {
    private List<Integer> list;
    private int[] nums;
//    private Random random;

    public Solution(int[] nums) {
        list = new LinkedList<>();
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            list.add(i);
        }
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        int[] ans = new int[nums.length];
        List<Integer> tempList = new LinkedList<>(list);
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(tempList.size());
            ans[i] = tempList.get(index);
            tempList.remove(index);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Solution solution = new Solution(arr);
        int[] shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.println(i);
        }
        System.out.println("--------");
        shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.println(i);
        }
        System.out.println("--------");
        shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.println(i);
        }
        System.out.println("--------");
        shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.println(i);
        }
        System.out.println("--------");
        shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.println(i);
        }
        System.out.println("--------");

//        System.out.println(solution.shuffle());
//        System.out.println(solution.reset());
//        System.out.println(solution.shuffle());

    }
}
