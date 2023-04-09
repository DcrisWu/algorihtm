package competition.No_339_day_2023_4_2.code_6363_转换二维数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        while (!count.isEmpty()) {
            List<Integer> now = new ArrayList<>();
            now.addAll(count.keySet());
            for (Integer integer : now) {
                if (count.get(integer) == 1) {
                    count.remove(integer);
                } else {
                    count.put(integer, count.get(integer) - 1);
                }
            }
            ans.add(now);
        }
        return ans;
    }
}
