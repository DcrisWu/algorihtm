package TowardsOffer2_Special.day_10_哈希表.code_031_最近最少使用缓存;

import java.util.*;

/**
 * completion time = 2022.10.22
 */
public class LRUCache {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        //队列存储的是键
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //如果存在这个key，就把这个键放在队列的后面，然后返回
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //如果已经包含了这个键，替换值就行，
        if (map.containsKey(key)) {
            //修改map里面的值
            map.put(key, value);
            //将队列中的key删去，再塞到队列尾
            queue.remove(key);
            queue.add(key);
        } else {
            if (map.size() < capacity) {
                map.put(key, value);
                queue.add(key);
            } else {
                Integer first = queue.poll();
                map.remove(first);
                map.put(key, value);
                queue.add(key);
            }
        }
    }
}
