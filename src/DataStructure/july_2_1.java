package DataStructure;

public class july_2_1 {

    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
        System.out.println(nums);
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && pivot <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && pivot >= arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public void quickSort(int[] arr, int left, int right) {
        int pivot;
        if(left < right){
            pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

    }
}
