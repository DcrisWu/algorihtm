package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class july_3_1 {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<>();
        //由C(n,m) = C(n,m-1) * (n - m +1) / m 得出递推公式
        ans.add(1);
        //i表示需要计算的第i个数字
        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int) ((long)ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;
    }
}
