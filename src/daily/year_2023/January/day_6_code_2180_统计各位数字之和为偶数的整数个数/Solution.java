package daily.year_2023.January.day_6_code_2180_统计各位数字之和为偶数的整数个数;

class Solution {
    public int countEven(int num) {
        int tens = num / 10;
        int count = 0;
        count += tens * 5;
        for(int i = tens * 10;i<=num;i++){
            if(check(i)){
                count++;
            }
        }
        return count-1;
    }

    boolean check(int num){
        int count = 0;
        while(num != 0){
            count += num % 10;
            num /= 10;
        }
        return count % 2 == 0;
    }
}
