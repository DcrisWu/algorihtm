package 灵茶2022年周赛总结.下半年.模拟.code_2456_最流行的视频创作者;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * completion time = 2023.5.15
 */
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        // int[0] 表示播放量总和，int[1]表示播放量最高的视频的ids的下标，int[2]表示播放量最高的视频的播放量
        Map<String, long[]> users = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            users.putIfAbsent(creators[i], new long[]{-1, -1, -1});
            long[] ints = users.get(creators[i]);
            // 如果是第一次遇到这个creator
            if (ints[0] == -1) {
                ints[0] = views[i];
                ints[1] = i;
                ints[2] = views[i];
            } else {
                ints[0] += views[i];
                if ((views[i] > ints[2]) || (views[i] == ints[2] && ids[i].compareTo(ids[(int)ints[1]]) < 0)) {
                    ints[1] = i;
                    ints[2] = views[i];
                }
            }
        }
        List<String> max = new ArrayList<>();
        for (String key : users.keySet()) {
            long[] ints = users.get(key);
            long popular = ints[0];
            if (max.isEmpty()) {
                max.add(key);
            } else {
                String pre = max.get(0);
                long prePopular = users.get(pre)[0];
                if (popular == prePopular) {
                    max.add(key);
                } else if (popular > prePopular) {
                    max.clear();
                    max.add(key);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String creator : max) {
            List<String> temp = new ArrayList<>();
            temp.add(creator);
            temp.add(ids[(int) users.get(creator)[1]]);
            ans.add(temp);
        }
        return ans;
    }
}
