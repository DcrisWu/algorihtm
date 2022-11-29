package daily.year_2022.July;

public class july_16 {
    private int[] arr;
    private int now;
    private int size;

    public july_16(int size) {
        arr = new int[size];
        now = 0;
        this.size = size;
    }

    public double next(int val) {
        arr[now % size] = val;
        now++;
        double total = 0;
        //数组还没满的时候
        if (now < size) {
            for (int i = 0; i < now; i++) {
                total += arr[i];
            }
            return total / now;
        } else {
            //如果数组已经满了
            for (int i = 0; i < size; i++) {
                total += arr[i];
            }
            return total / size;
        }
    }
}
