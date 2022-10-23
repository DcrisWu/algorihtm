package BinarySearch;

import java.awt.*;
import java.util.Arrays;

/**
 * code_826
 */
public class eleven_1 {
    public static void main(String[] args) {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        //根据工作难度排序
        Arrays.sort(jobs, (a, b) -> a.x - b.x);
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }
//    HashMap<Integer, Integer> map = new HashMap<>();
//        int salary = 0;
//        int n = difficulty.length;
//        for (int i = 0; i < n; i++) {
//            //将受益作为key,下标作为value
//            if (map.containsKey(profit[i])) {
//                //如果受益相同，但是原来对应下标的工作的困难程度 > 现在对应的工作难度，那么将下标更新为现在这个
//                if(difficulty[map.get(profit[i])] > difficulty[i]){
//                    map.replace(profit[i], i);
//                }
//            } else {
//                map.putIfAbsent(profit[i], i);
//            }
//        }
//        Arrays.sort(profit);
//        for (int i = 0; i < worker.length; i++) {
//            int person = worker[i], l = 0, r = n - 1;
//            int index = -1;
//            while (l <= r) {
//                int mid = (l + r) >> 1;
//                if (difficulty[mid] <= person) {
//                    l = mid + 1;
//                    index = mid;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            salary += (index == -1 ? 0 : profit[map.get(difficulty[index])]);
//        }
//        return salary;
}
