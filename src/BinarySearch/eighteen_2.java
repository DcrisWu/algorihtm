package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * code_1488
 */
public class eighteen_2 {
    public static void main(String[] args) {
        int[] arr = {1,0,2,0,3,0,2,0,0,0,1,2,3};
        eighteen_2 eighteen_2 = new eighteen_2();
        System.out.println(eighteen_2.avoidFlood(arr));
    }
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = rains.length;
        int[] ans = new int[n];
        List<Integer> index = new ArrayList<>();
//        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                index.add(i);
            } else {
                ans[i] = -1;
                if (!map.containsKey(rains[i])) {
                    map.putIfAbsent(rains[i], i);
                } else {
                    if (map.get(rains[i]) == -1) {
                        map.replace(rains[i], i);
                    } else {
                        if (index.isEmpty()) {
                            return new int[]{};
                        } else {
                            int last = map.get(rains[i]);
                            int ind = 0;
                            while (ind < index.size() && index.get(ind) <= last) {
                                ind++;
                            }
                            if (ind < index.size()) {
                                Integer integer = index.get(ind);
                                index.remove(ind);
                                ans[integer] = rains[i];
                                map.replace(rains[i], i);
                            }else {
                                return new int[]{};
                            }
                        }
                    }
                }
            }
        }
        for (Integer integer : index) {
            ans[integer] = 1;
        }
        return ans;
    }
}
