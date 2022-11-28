package competition.day_2022_11_27.code_6245_找出中枢整数;

class Solution {
    public int pivotInteger(int n) {
        int l = 1, r = n;
        int x = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int left = (1 + mid) * mid;
            int right = (mid + n) * (n - mid + 1);
            if (left == right) {
                x = mid;
                break;
            } else if (left > right) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(8));
    }
}
