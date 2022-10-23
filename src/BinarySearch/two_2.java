package BinarySearch;

/**
 * code_1894
 */
public class two_2 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if(sum > k){
                return i;
            }
        }
        int res = k % sum;
        int index = 0;
        while (chalk[index] <= res){
            res -= chalk[index];
            index++;
        }
        return index;
    }
}
