package BasicCoding.day_8.code_973;

import java.util.*;

/**
 * completion time = 2022.10.5
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{3,3},{5,-1},{-2,4}};
        System.out.println(solution.kClosest(arr, 2));
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        int[] dis = new int[points.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dis.length; i++) {
            int temp = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(i);
            dis[i] = temp;
        }
        Arrays.sort(dis);
        int i = 0;
        for (int m = 0; m < dis.length; m++) {
            List<Integer> list = map.get(dis[m]);
            for (int n = 0; n < list.size(); n++) {
                if(i >= k){
                    break;
                }
                ans[i] = points[list.get(n)];
                i++;
            }
            if (i >= k){
                break;
            }
        }
        return ans;
    }
}
