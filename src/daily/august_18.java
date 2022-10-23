package daily;

import java.util.*;

public class august_18 {
    public static int maxEqualFreq(int[] nums) {
        /*Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, List<Integer>> freq = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.putIfAbsent(num, 1);
            } else {
                count.replace(num, count.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : count.entrySet()) {
            max = Math.max(max, integerIntegerEntry.getValue());
            freq.putIfAbsent(integerIntegerEntry.getValue(), new ArrayList<>());
            freq.get(integerIntegerEntry.getValue()).add(integerIntegerEntry.getKey());
        }
        if ()*/
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            boolean ok = maxFreq == 1 ||
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,2,1,1,5,3,3,5};
        maxEqualFreq(arr);
    }
}
