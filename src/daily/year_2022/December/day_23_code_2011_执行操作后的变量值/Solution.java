package daily.year_2022.December.day_23_code_2011_执行操作后的变量值;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")){
                ans += 1;
            }else {
                ans -= 1;
            }
        }
        return ans;
    }
}