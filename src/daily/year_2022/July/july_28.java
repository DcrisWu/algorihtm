package daily.year_2022.July;

import java.util.Arrays;
import java.util.HashMap;

public class july_28 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return arr;
        }
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        map.put(temp[0], index);
        for (int i = 1; i < n; i++) {
            if (temp[i] > temp[i - 1]) {
                index++;
            }
            map.putIfAbsent(temp[i], index);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
