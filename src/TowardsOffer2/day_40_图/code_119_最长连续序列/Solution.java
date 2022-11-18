package TowardsOffer2.day_40_图.code_119_最长连续序列;

import java.io.Serializable;
import java.util.*;

class Solution {
    /*public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
        }
        int ans = 0;
        for (int num : nums) {
            if (map.get(num) == 0) {
                ans = Math.max(ans, dfs(map, num));
            }
        }
        return ans;
    }

    int dfs(Map<Integer, Integer> map, int num) {
        // 如果不存在 num+1
        if (!map.containsKey(num + 1)) {
            map.put(num, 1);
            return 1;
        }
        // 如果存在
        // 如果 num+1已经被遍历过，就直接读
        if (map.get(num + 1) != 0) {
            map.put(num, map.get(num + 1) + 1);
        } else {
            // 否则递归
            map.put(num, dfs(map, num + 1) + 1);
        }
        return map.get(num);
    }*/

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer integer : set) {
            if (set.contains(integer - 1)) {
                continue;
            }
            int current = 1;
            int curNum = integer;
            while (set.contains(curNum + 1)) {
                current++;
                curNum++;
            }
            longest = Math.max(longest, current);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(arr));
    }
}
