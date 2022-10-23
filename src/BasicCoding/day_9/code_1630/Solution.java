package BasicCoding.day_9.code_1630;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.10.7
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new LinkedList<>();
        for (int k = 0; k < l.length; k++) {
            int left = l[k], right = r[k];
            int[] temp = new int[right - left + 1];
            System.arraycopy(nums, left, temp, 0, right - left + 1);
            Arrays.sort(temp);
            if(temp.length < 3){
                ans.add(true);
            }else {
                int dis = temp[1]-temp[0];
                boolean judge = true;
                for (int i = 2;i< temp.length;i++){
                    if(temp[i] - temp[i-1] != dis){
                        ans.add(false);
                        judge = false;
                        break;
                    }
                }
                if (judge){
                    ans.add(true);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        System.out.println(solution.checkArithmeticSubarrays(nums, l, r));
    }
}

