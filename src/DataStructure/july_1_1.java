package DataStructure;

import java.util.HashMap;
import java.util.Hashtable;

public class july_1_1 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, true);
            } else {
                map.remove(num);
            }
        }
        int key = 0;
        for (Integer integer : map.keySet()) {
            key = integer;
        }

        return key;
    }

}
