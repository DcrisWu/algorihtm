package Random.code_134_加油站;

/**
 * completion time = 2023.7.27
 */
class Solution {
    // 就是找出一段油量总和 >= 耗油总和的子数组的第一个下标，并且满足总油量 >= 总耗油量
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tgas = 0;
        int tcost = 0;
        int min = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            tgas += gas[i];
            tcost += cost[i];
            if (tgas - tcost < min) {
                min = tgas - tcost;
                idx = i;
            }
        }
        if (tgas < tcost) {
            return -1;
        }
        return (idx + 1) % n;
    }
}
