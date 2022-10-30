package TowardsOffer2.day_19_树.code_058_日程表;

import Pack.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.10.30
 */
class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] ints : list) {
            if (start < ints[1] && end > ints[0]) {
                return false;
            }
        }
        int[] point = {start,end};
        list.add(point);
        return true;
    }
}
