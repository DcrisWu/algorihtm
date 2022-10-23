package BasicCoding.day_1.code_896;

/**
 * completion time = 2022.10.1
 */
public class Solution {
    public boolean isMonotonic(int[] nums) {
        //false表示递减，true表示递增
        boolean judge = false;
        int mark = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] > nums[i - 1]) {
                judge = true;
                mark = i;
                break;
            } else {
                judge = false;
                mark = i;
                break;
            }
        }
        if (judge) {
            for (int i = mark + 1; i < nums.length; i++) {
                if(nums[i] < nums[i-1]){
                    return false;
                }
            }
        }else {
            for (int i= mark+1;i< nums.length;i++){
                if(nums[i] > nums[i-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
