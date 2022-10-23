package BinarySearch;

/**
 * code_1760
 */
public class three_2 {
    public int minimumSize(int[] nums, int maxOperations) {
        //min，max分别表示最小开销和最大开销
        int min = 1;
        int max = 1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int mid = (min + max) / 2;
        while (min < max) {
            //times表示需要操作的次数
            int times = 0;
            //mid表示取折中的开销
            mid = (min + max) / 2;
            for (int num : nums) {
                times += (num - 1) / mid;
            }
            //如果所需要的次数>maxOperations，则这个mid取得太小了
            if (times > maxOperations) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
