package competition.leetcode_weekly.No_344_day_2023_5_7.code_6417_频率跟踪器;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * completion time = 2023.5.7
 */
class FrequencyTracker {

    private Map<Integer, Integer> numCount;
    private Map<Integer, Set<Integer>> count;

    public FrequencyTracker() {
        numCount = new HashMap<>();
        count = new HashMap<>();
        count.put(0, new HashSet<>());
    }

    public void add(int number) {
        Integer pre = numCount.getOrDefault(number, 0);
        numCount.put(number, pre + 1);
        Set<Integer> integerSet = count.get(pre);
        integerSet.remove(number);
        count.putIfAbsent(pre + 1, new HashSet<>());
        count.get(pre + 1).add(number);

    }

    public void deleteOne(int number) {
        if (!numCount.containsKey(number)) {
            return;
        }
        Integer pre = numCount.get(number);
        if (pre == 0){
            return;
        }
        numCount.put(number, pre - 1);
        Set<Integer> set = count.get(pre);
        set.remove(number);
        count.putIfAbsent(pre - 1, new HashSet<>());
        count.get(pre - 1).add(number);
    }

    public boolean hasFrequency(int frequency) {
        return count.containsKey(frequency) && count.get(frequency).size() > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
