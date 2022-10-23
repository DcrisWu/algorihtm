package BasicCoding.day_20.code_380;

import java.util.*;

/**
 * completion time = 2022.10.13
 */
public class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Long> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        List<List<Integer>> list = new LinkedList<>();
        Iterator<List<Integer>> iterator = list.iterator();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add((long) val);
            map.putIfAbsent(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            list.set(map.get(val), (long) (Integer.MIN_VALUE) - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int i = Math.abs(random.nextInt() % list.size());
        while (list.get(i) == (long) Integer.MIN_VALUE - 1){
            i = Math.abs(random.nextInt() % list.size());
        }
        return Math.toIntExact(list.get(i));
    }
}
