package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class august_16 {

    String[] str;
    int index = 1;

    public august_16(int n) {
        str = new String[n+1];
        Arrays.fill(str,null);
    }

    public List<String> insert(int idKey, String value) {
        str[idKey] = value;
        List<String> ans = new ArrayList<>();
//        int index = idKey;
        for(int i = index; i < str.length && str[i] != null;i++){
            ans.add(str[i]);
            index = i;
        }
        index++;
        return ans;
    }

}
