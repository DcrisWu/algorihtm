package BinarySearch;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * code_1146
 */
public class eighteen_1 {
//    private int[] arr;
    private List<Point>[] sn;
    private int times;

    public eighteen_1(int length) {
        sn = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            sn[i] = new ArrayList<>();
            //x表示值，y表示快照id
            sn[i].add(new Point(0, times));
        }
        times = 0;
    }

    public void set(int index, int val) {
        sn[index].add(new Point(val, times));
    }

    public int snap() {
        return times++;
    }

    public int get(int index, int snap_id) {
        List<Point> list = sn[index];
        int n = list.size() - 1;
        while (list.get(n).y > snap_id) {
            n--;
        }
        return list.get(n).x;
    }
}
