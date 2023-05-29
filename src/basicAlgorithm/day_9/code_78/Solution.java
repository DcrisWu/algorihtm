package basicAlgorithm.day_9.code_78;

import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.21
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.subsets(arr));
    }
    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            ans.add(list);
            dfs(nums, list, i);
        }
        return ans;
    }

    public void dfs(int[] nums, List<Integer> last, int index) {
        for (int i = index+1;i<nums.length;i++){
            List<Integer> list = new LinkedList<>(last);
            list.add(nums[i]);
            ans.add(list);
            dfs(nums,list,i);
        }
    }
}
