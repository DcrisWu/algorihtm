package daily.year_2022.December.day_30_code_855_考场就座;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

class ExamRoom {

    private PriorityQueue<int[]> heap;
    TreeSet<Integer> set;
    private int n;

    public ExamRoom(int n) {
        this.n = n;
        set = new TreeSet<>();
        heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int d1 = (o1[1] - o1[0]) / 2;
                int d2 = (o2[1] - o2[0]) / 2;
                return d1 < d2 || (d1 == d2 && o1[0] > o2[0]) ? 1 : -1;
            }
        });
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        int left = set.first();
        int right = n - 1 - set.last();
        while (set.size() >= 2) {
            int[] peek = heap.peek();
            if (set.contains(peek[0]) && set.contains(peek[1]) && set.higher(peek[0]) == peek[1]) {
                if (left >= (peek[1] - peek[0]) / 2 || (peek[1] - peek[0]) / 2 < right) {
                    break;
                }
                heap.poll();
                int mid = peek[0] + (peek[1] - peek[0]) / 2;
                int[] pre = {peek[0], mid};
                int[] next = {mid, peek[1]};
                set.add(mid);
                heap.add(pre);
                heap.add(next);
                return mid;
            }
            heap.poll();
        }
        if (left >= right) {
            int[] now = {0, left};
            set.add(0);
            heap.add(now);
            return 0;
        } else {
            int[] now = {set.last(), n - 1};
            set.add(n - 1);
            heap.add(now);
            return n - 1;
        }
    }

    public void leave(int p) {
        if (p != set.first() && p != set.last()) {
            int pre = set.lower(p);
            int next = set.higher(p);
            int[] now = {pre, next};
            heap.add(now);
        }
        set.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(4);
        examRoom.seat();
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */