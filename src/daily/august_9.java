package daily;

public class august_9 {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        int min = ans[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
            min = Math.min(ans[i], min);
        }
        return min > 0 ? min : (0 - min + 1);
    }
}
