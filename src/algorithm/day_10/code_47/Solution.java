package algorithm.day_10.code_47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1};
        System.out.println(solution.permuteUnique(arr));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        List<Integer> first = new LinkedList<>();
        for (int num : nums) {
            first.add(num);
        }
        ans.add(first);
        int n = nums.length;
        boolean judge = false;
        while (true) {
            int size = ans.size();
            for (int i = 0; i < n - 1; i++) {
                if (ans.get(size - 1).get(i) < ans.get(size - 1).get(i + 1)) {
                    judge = true;
                    break;
                } else {
                    judge = false;
                }
            }
            if (judge) {
                int i = 0, j = i + 1;
                int index = 0;
                //找出是的a(i) < a(i+1)的最大的i
                while (index < n - 1) {
                    if (ans.get(size - 1).get(index) < ans.get(size - 1).get(index + 1)) {
                        i = index;
                    }
                    index++;
                }
                //寻找满足a(i) < a(j)的最大j值
                for (int k = i + 1; k < n; k++) {
                    if (ans.get(size - 1).get(k) > ans.get(size - 1).get(i)) {
                        j = k;
                    }
                }
                List<Integer> temp = new LinkedList<>(ans.get(size - 1));
                //交换a(i)和a(j)
                int aa = temp.get(i);
                temp.set(i, ans.get(size - 1).get(j));
                temp.set(j, aa);
                //将a(i+1)到a(n)的元素反序
//                for (int k = 1; k < n - i ; k++) {
//                    Integer bb = ans.get(size - 1).get(n - k);
//                    Integer ccc = temp.get(k + i);
//                    temp.set(k + i, ans.get(size - 1).get(n - k));
//                }
                List<Integer> integers = new LinkedList<>();
                for (int k = i + 1; k < n; k++) {
                    integers.add(temp.get(k));
                }
                for (int k = 0; k < integers.size(); k++) {
                    temp.set(n - k - 1, integers.get(k));
                }
                ans.add(temp);
            } else {
                break;
            }
        }
        return ans;
    }
}
