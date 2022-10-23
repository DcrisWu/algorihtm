package DataStructure;


public class july_5_1 {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            //如果nums[i]大于second，就找到了符合条件的三元组
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                //如果nums[i]大于first，就将second更新为nums[i]
                second = nums[i];
            } else {
                //如果nums[i]小于first，那么就将first更新为nums[i]，虽然此时first在second的后面
                //但是肯定有一个first'在second前面，所以遇到nums[i]大于second，则可以找到符合条件的三元组
                first = nums[i];
            }
        }
        return false;
    }
}
