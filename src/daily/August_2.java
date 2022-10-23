package daily;

public class August_2 {

    private int[] arr;
    private int head = -1;
    private int end = -1;
    private int length;

    public August_2(int k) {
        arr = new int[k];
        length = k;
    }

    public boolean enQueue(int value) {
        //如果数组是空的话
        if (head == -1) {
            arr[0] = value;
            head = 0;
            end = 0;
            return true;
        }
        //如果不是空的数组，则检查是否还有空间
        else if ((end + 1) % length != head) {
            arr[(end+1) % length] = value;
            end = (end+1)% length;
            return true;
        }
        //如果已经没有空间了，就返回false
        else {
            return false;
        }
    }

    public boolean deQueue() {
        //如果数组本身为空，就无法删除
        if (head == -1) {
            return false;
        }
        //如果删除后数组为空，head == end == -1
        else if (head == end) {
            head = -1;
            end = -1;
        }
        //删除后数组不为空
        else {
            head = (head + 1) % length;
        }
        return true;
    }

    public int Front() {
        //如果数组本身为空，就返回-1
        return head == -1 ? -1 : arr[head];
    }

    public int Rear() {
        //如果数组本身为空，就返回-1
        return head == -1 ? -1 : arr[end];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (end + 1) % length == head;
    }

    public static void main(String[] args) {
        August_2 august_2 = new August_2(3);
        System.out.println(august_2.enQueue(1));
        System.out.println(august_2.enQueue(2));
        System.out.println(august_2.enQueue(3));
        System.out.println(august_2.enQueue(4));
        System.out.println(august_2.Rear());
        System.out.println(august_2.isFull());
        System.out.println(august_2.deQueue());
        System.out.println(august_2.enQueue(4));
        System.out.println(august_2.Rear());
    }
}
