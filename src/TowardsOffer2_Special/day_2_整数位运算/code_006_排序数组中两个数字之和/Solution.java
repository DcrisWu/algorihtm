package TowardsOffer2_Special.day_2_整数位运算.code_006_排序数组中两个数字之和;

/**
 * completion time
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            map.putIfAbsent(numbers[i], i);
//        }
//        int[] ans = new int[2];
//        for (int i = 0;i< numbers.length;i++){
//            if(map.containsKey(target-numbers[i])){
//                Integer integer = map.get(target - numbers[i]);
//                if(integer != i){
//                    ans[0] = Math.min(integer,i);
//                    ans[1] = Math.max(integer,i);
//                    break;
//                }
//            }
//        }
//        return ans;

        //方法二
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int index = find(numbers, target - numbers[i]);
            if (index != -1 && index != i) {
                ans[0] = Math.min(index, i);
                ans[1] = Math.max(index, i);
                break;
            }
        }
        return ans;
    }

    public int find(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
