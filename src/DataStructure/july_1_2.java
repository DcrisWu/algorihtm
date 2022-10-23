package DataStructure;

import java.util.HashMap;

public class july_1_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //还未存入
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            //已经存入一个了，就再放一个进去
            else {
                map.replace(num, map.get(num) + 1);
            }
        }
        int key = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > nums.length / 2) {
                key = integer;
            }

        }
        return key;
    }
}

