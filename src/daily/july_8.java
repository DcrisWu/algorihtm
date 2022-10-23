package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class july_8 {

    public int minCostToMoveChips(int[] position) {

        int odd = 0;
        int even = 0;
        for (int i : position) {

            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return odd < even == true ? odd : even;
    }
}
