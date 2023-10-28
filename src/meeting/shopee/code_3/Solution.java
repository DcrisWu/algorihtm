package meeting.shopee.code_3;

import java.util.*;


public class Solution {

    public String moveSubStr(String str, int n) {
        return str.substring(n - 1) + str.substring(0, n - 1);
    }
}

