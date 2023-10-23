package ByteDance.code_135_分发糖果;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] add = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                add[i] = Math.max(add[i], add[i - 1] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                add[i] = Math.max(add[i], add[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : add) {
            sum += i;
        }
        return sum + n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2};
        System.out.println(solution.candy(arr));
    }
}