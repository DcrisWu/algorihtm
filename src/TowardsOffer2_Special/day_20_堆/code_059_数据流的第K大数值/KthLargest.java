package TowardsOffer2_Special.day_20_堆.code_059_数据流的第K大数值;

import java.util.PriorityQueue;

/**
 * completion time = 2022.10.31
 */
class KthLargest {

    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if(queue.size() < k){
                queue.add(num);
            }else {
                queue.add(num);
                queue.poll();
            }
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            queue.add(val);
        }else {
            queue.add(val);
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] arr = {};
        KthLargest kthLargest = new KthLargest(1, arr);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }
}
