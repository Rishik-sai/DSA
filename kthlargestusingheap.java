import java.util.Random;

public class kthlargestusingheap {
    public static int kthLargestElement(int[] nums, int k) {
        if (k > nums.length) return -1;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivotIndex = randomIndex(left, right);
            pivotIndex = partitionAndReturnIndex(nums, pivotIndex, left, right);
            if (pivotIndex == k - 1) return nums[pivotIndex];
            else if (pivotIndex > k - 1) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }
    
    private static final Random rand = new Random();
    private static int randomIndex(int left, int right) {
        int len = right - left + 1;
        return rand.nextInt(len) + left;
    }
    private static int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {
        int pivot = nums[pivotIndex];
        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        int ind = left + 1; 
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > pivot) {
                temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;
                ind++;
            }
        }
        temp = nums[left];
        nums[left] = nums[ind - 1];
        nums[ind - 1] = temp;
        return ind - 1;
    }
    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        int k = 5;
        int ans = kthLargestElement(nums, k);
        System.out.println("The Kth largest element in the array is: " + ans);
    }
}
