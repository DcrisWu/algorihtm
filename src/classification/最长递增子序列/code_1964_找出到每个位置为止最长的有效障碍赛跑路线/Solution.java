package classification.最长递增子序列.code_1964_找出到每个位置为止最长的有效障碍赛跑路线;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.21
 */
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[obstacles.length];
        list.add(obstacles[0]);
        res[0] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            int l = 0, r = list.size() - 1;
            int idx = list.size();
            while (l <= r) {
                int mid = (l + r) >> 1;
                // 因为这里不需要严格递增，所以需要找到第一个 > obstacles[i]的下标，并替换
                if (list.get(mid) > obstacles[i]) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (idx == list.size()) {
                list.add(obstacles[i]);
                res[i] = list.size();
            } else {
                list.set(idx, obstacles[i]);
                res[i] = idx + 1;
            }
        }
        return res;
    }
}