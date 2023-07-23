package competition.leetcode_weekly.No_355_day_2023_7_23.code_6955_长度递增组的最大数目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * completion time = 2023.7.23
 *
 * 不是能够想到的问题，放弃
 */
class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long cur = 0;
        int ans = 0;
        for (Integer v : usageLimits) {
            cur += v;
            // 已经有ans个组合，第ans个组合至少有ans个元素，那么下一个元素的频率至少要ans + 1
            // 越靠前的数据，在越后面的组合中出现
            // 例如 1 2 2，遍历后的ans序列为 1 2 2，对应的组合是 [2], [1, 2], [1, 2]
            // 换句话说，之所以要求cur >= ans + 1，是为了要求 cur 频率的数字做长度为1的组合
            if (cur >= ans + 1) {
                ans += 1;
                // cur -= ans是因为只需要减去使用了的频率即可，下一次还可以复用
                // 例 2, 2, 2，
                cur -= ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        list.add(999999998);
        System.out.println(new Solution().maxIncreasingGroups(list));
    }
}
