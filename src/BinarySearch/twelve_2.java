package BinarySearch;

/**
 * code_162
 */
public class twelve_2 {
    public static void main(String[] args) {
        int[] arr = {-2147483648};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        return judge(nums, 0, nums.length - 1);
    }

    public static int judge(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) >> 1;
        long left = mid - 1 == -1 ? Long.valueOf(Integer.MIN_VALUE) - 1 : nums[mid - 1];
        long right = mid + 1 == nums.length ? Long.valueOf(Integer.MIN_VALUE) - 1 : nums[mid + 1];
        if (nums[mid] > left && nums[mid] > right) {
            return mid;
        } else if(l == r){
            return -1;
        }else {
            int a = judge(nums, l, mid );
            if(a != -1){
                return a;
            }
            int b = judge(nums, mid+1, r );
            if(b != -1){
                return b;
            }
            return -1;
        }

    }
}
