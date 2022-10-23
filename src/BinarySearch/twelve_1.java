package BinarySearch;

/**
 * code_81
 */
public class twelve_1 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        System.out.println(search(arr, 0));
    }
    public static boolean search(int[] nums, int target) {
        for (int num : nums) {
            if(num == target){
                return true;
            }
        }
        return false;
    }
}
