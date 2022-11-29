package daily.year_2022.July;

import java.util.HashMap;
import java.util.Map;

public class july_19 {
    private Map<Integer, int[]> tree;

    public july_19() {
        tree = new HashMap<>();
    }

    public boolean book(int start, int end) {
//        1000000000
        update2(start, end - 1, 1, 0, 10, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update2(start, end - 1, -1, 0, 10, 1);
            return false;
        }
        return true;
    }

    public void update2(int start, int end, int value, int l, int r, int index) {
        if (start > r || end < l) {
            return;
        }
        tree.putIfAbsent(index, new int[2]);
        if (start <= l && end >= r) {
            tree.get(index)[0] += value;
            tree.get(index)[1] += value;
        } else {
            int mid = (l + r) >> 1;
            update2(start, end, value, l, mid, index * 2);
            update2(start, end, value, mid + 1, r, index * 2 + 1);
            tree.putIfAbsent(index * 2, new int[2]);
            tree.putIfAbsent(index * 2 + 1, new int[2]);
            tree.get(index)[0] = tree.get(index)[1] + Math.max(tree.get(index * 2)[0], tree.get(index * 2 + 1)[0]);
        }
    }

    public static void main(String[] args) {
        july_19 july_19 = new july_19();
        System.out.println(july_19.book(5, 7));
    }

}
