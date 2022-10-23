package BinarySearch;

/**
 * code_540
 */
public class nine_2 {
    public static void main(String[] args) {
        int[] arr = {7, 7, 10, 11, 11, 12, 12};
        nine_2 nine_2 = new nine_2();
        System.out.println(nine_2.singleNonDuplicate(arr));
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        return find(nums, 2, n - 3);
    }

    public int find(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) >> 1;
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }
        int a = find(nums, l, mid - 1);
        if(a != -1){
            return a;
        }
        int b = find(nums, mid + 1, r);
        if(b != -1){
            return b;
        }
        return -1;
    }
}
