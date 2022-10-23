package BasicCoding.day_17.code_1845;

import java.util.*;

/**
 * completion time = 2022.10.11
 */
public class SeatManager {
    private PriorityQueue<Integer> queue;

    public SeatManager(int n) {
        queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
