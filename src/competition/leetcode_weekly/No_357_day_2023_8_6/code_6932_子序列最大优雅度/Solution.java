package competition.leetcode_weekly.No_357_day_2023_8_6.code_6932_子序列最大优雅度;

import java.util.*;

/**
 * completion time = 2023.8.6
 */
class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        // 把利润从大到小排序
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        // 先将利润最大的k个加入total_profile中，再选择删除前k个元素
        // 如果k+1个的类别已经出现过，那么替换成 k+1 利润不会增加
        // 如果k+1个类别没有出现过，就可以尝试进行替换
        // 如果被替换的 j 只出现过一次，那么替换后 种类总数 没有改变，利润减少，所以不替换
        // 如果被替换的 j 出现过超过1次，那么它可以被替换，尝试将利润最小的j替换掉，再比较是否大于原有的答案就行了
        // 类别出现过超过1次的利润可以用栈表示
        long ans = 0, totalProfit = 0;
        HashSet<Integer> vis = new HashSet<>();
        // 用栈记录可以被替换的利润
        Deque<Integer> duplicate = new ArrayDeque<>();
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0], category = items[i][1];
            if (i < k) {
                totalProfit += profit;
                // 添加失败
                if (!vis.add(category)) {
                    duplicate.addLast(profit);
                }
            } else if (!duplicate.isEmpty() && vis.add(category)) {
                // 为什么直接替换掉？
                // 因为假如替换后，totalProfit没有变大就选择不替换，那么后面就算再遇到一个新的类型，类型种类总数还是 before + 1，但是利润更少了，不可能变得更大
                // 唯一有可能出现更大的情况，就是利润虽然变少了，但是种类一直变多，所以遇到新种类，直接替换
                Integer pro = duplicate.pollLast();
                totalProfit += profit - pro;
            }
            ans = Math.max(ans, totalProfit + (long) vis.size() * vis.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] items = {{3, 2}, {5, 1}, {10, 1}};
        System.out.println(new Solution().findMaximumElegance(items, 2));
    }
}
