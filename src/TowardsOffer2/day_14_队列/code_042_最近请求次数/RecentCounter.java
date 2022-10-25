package TowardsOffer2.day_14_队列.code_042_最近请求次数;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.10.25
 */
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
