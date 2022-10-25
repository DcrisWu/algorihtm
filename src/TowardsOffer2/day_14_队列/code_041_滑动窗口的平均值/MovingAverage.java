package TowardsOffer2.day_14_队列.code_041_滑动窗口的平均值;

/**
 * completion time = 2022.10.25
 */
class MovingAverage {

    /**
     * Initialize your data structure here.
     */
    private int[] arr;
    private int now;
    private int size;
    private int sum;

    public MovingAverage(int size) {
        arr = new int[size];
        now = -1;
        this.size = 0;
        this.sum = 0;
    }

    public double next(int val) {
        now = (now + 1) % arr.length;
        if (size < arr.length) {
            size++;
        } else {
            sum -= arr[now];
        }
        arr[now] = val;
        sum += arr[now];
        return (double) sum / size;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(5));
    }
}