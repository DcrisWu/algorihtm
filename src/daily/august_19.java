package daily;

import java.util.ArrayList;
import java.util.List;

public class august_19 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        List<Integer> ans = new ArrayList<>();
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans.add(i);
            }
        }
        return ans.size();
    }
}
