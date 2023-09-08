package classification.回溯.code_2698_求一个整数的惩罚数;

/**
 * completion time = 2023.9.8
 */
class Solution {
    public int punishmentNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            String s = String.valueOf(num);
            if (dfs(0, s, 0, i)) {
                count += num;
            }
        }
        return count;
    }

    public boolean dfs(int idx, String num, int pre, int target) {
        if (idx == num.length()) {
            return pre == target;
        }
        for (int i = idx; i < num.length(); i++) {
            int now = pre + Integer.parseInt(num.substring(idx, i + 1));
            if (dfs(i + 1, num, now, target)) {
                return true;
            }
        }
        return false;
    }

}
