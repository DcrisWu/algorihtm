package TowardsOffers2.code_41_数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

class MedianFinder {

    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (min.isEmpty()) {
            min.add(num);
            return;
        }
        if (min.size() == max.size()) {
            if (num >= max.peek()) {
                min.add(max.poll());
                max.add(num);
            } else {
                min.add(num);
            }
        } else {
            if (num >= min.peek()) {
                max.add(num);
            } else {
                max.add(min.poll());
                min.add(num);
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return ((double) min.peek() + (double) max.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(40);
        medianFinder.addNum(12);
        medianFinder.addNum(16);
//        medianFinder.addNum(14);
//        medianFinder.addNum(35);
        System.out.println(medianFinder.findMedian());

    }
}
