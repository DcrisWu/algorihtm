package daily;

import java.util.ArrayList;
import java.util.List;

public class july_5 {

    private List<List<Integer>> bookList = new ArrayList<>();

    public july_5() {

    }

    public boolean book(int start, int end) {

        for (List<Integer> integerList : bookList) {
            if (!(end <= integerList.get(0)) && !(start >= integerList.get(1))) {
                return false;
            }
        }
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(0,start);
        pair.add(1,end);
        bookList.add(pair);
        return true;
    }
}
