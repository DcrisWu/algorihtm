package daily.year_2022.August;

public class august_26 {
    public int maxProduct(int[] nums) {
        int max = nums[0], second = nums[1];
        if (max < second) {
            int temp = max;
            max = second;
            second = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (max-1) * (second-1);
    }
}
