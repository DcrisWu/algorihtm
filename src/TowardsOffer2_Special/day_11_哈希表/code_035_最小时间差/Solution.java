package TowardsOffer2_Special.day_11_哈希表.code_035_最小时间差;

import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 24 * 60){
            return 0;
        }
        Object[] objects = timePoints.toArray();
        Arrays.sort(objects);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < objects.length; i++) {
            String pre = (String) objects[i - 1];
            String now = (String) objects[i];
            int time = (Integer.parseInt(now.substring(0, 2)) - Integer.parseInt(pre.substring(0, 2))) * 60 + Integer.parseInt(now.substring(3, 5)) - Integer.parseInt(pre.substring(3, 5));
            ans = Math.min(ans,time);
        }
        int time = (Integer.parseInt(((String) objects[0]).substring(0,2))+24 - Integer.parseInt(((String) objects[objects.length-1]).substring(0,2)))*60 + Integer.parseInt(((String) objects[0]).substring(3,5)) - Integer.parseInt(((String) objects[objects.length-1]).substring(3,5));
        ans = Math.min(ans,time);
        return ans;
    }
}