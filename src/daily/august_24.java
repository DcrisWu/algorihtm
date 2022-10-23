package daily;

import java.util.HashMap;
import java.util.Map;

public class august_24 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.putIfAbsent(i, 1);
            } else {
                map.replace(i, map.get(i) + 1);
            }
        }
        for (int i : target) {
            if (!map.containsKey(i)) {
                return false;
            }
            if (map.get(i) == 0) {
                return false;
            } else {
                map.replace(i, map.get(i) - 1);
            }
        }
        return true;
    }
}
