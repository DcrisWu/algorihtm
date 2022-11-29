package daily.year_2022.August;

public class august_29 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n * 2; i += 2) {
            ans[i] = nums[i/2];
            ans[i + 1] = nums[i/2 + n];
        }
        return ans;
    }
}
