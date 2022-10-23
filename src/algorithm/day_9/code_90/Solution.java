package algorithm.day_9.code_90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.21
 */
public class Solution {
    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        ans.add(list);
        dfs(nums, -1, list);
        return ans;
    }

    public void dfs(int[] nums, int index, List<Integer> last) {
        if(index < nums.length-1){
            List<Integer> list = new LinkedList<>(last);
            list.add(nums[index + 1]);
            ans.add(list);
            dfs(nums,index+1,list);
        }
        for (int i = index+2;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }else {
                List<Integer> temp = new LinkedList<>(last);
                temp.add(nums[i]);
                ans.add(temp);
                dfs(nums,i,temp);
            }
        }
    }
}
