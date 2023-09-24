package Random.code_295_数据流的中位数;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public MedianFinder() {
        // 小顶堆的堆顶 > 大顶推的堆顶
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (min.isEmpty()) {
            min.add(num);
        }else {
            if (num < min.peek()){
                max.add(num);
            }else {
                min.add(num);
            }
        }
        // 保持双方的数量差 <= 1
        if (min.size() > max.size() + 1) {
            max.add(min.poll());
        }
        if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        } else if (min.size() < max.size()) {
            return max.peek();
        } else {
            double res = ((double) min.peek() + (double) max.peek()) / 2.0;
            return res;
        }
    }
}
